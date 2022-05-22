package mx.uady.sicei.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class UploadFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileService.class);

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws_sicei_bucket}")
    private String bucketName;

    public String uploadFile(final MultipartFile multipartFile) {
        final File file = convertMultiPartFileToFile(multipartFile);
        String url = uploadFileToS3Bucket(bucketName, file);
        LOGGER.info("Archivo enviado a S3");
        file.delete(); 
        return url;
    }

    private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
        final File file = new File(multipartFile.getOriginalFilename());
        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (final IOException ex) {
            LOGGER.info("Error al convertir archivo");
        }
        return file;
    }

    private String uploadFileToS3Bucket(String bucketName, File file) {
        String keyFile = UUID.randomUUID() + "-" + file.getName();
        PutObjectRequest putObjectRequest =  new PutObjectRequest(bucketName, keyFile, file)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        amazonS3.putObject(putObjectRequest);
        return amazonS3.getUrl(bucketName, keyFile).toString();
    }
}