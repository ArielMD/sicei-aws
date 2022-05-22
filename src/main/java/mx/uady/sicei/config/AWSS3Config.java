package mx.uady.sicei.config;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
 
@Configuration
public class AWSS3Config {
 
    @Value("${aws_sicei_access_key_id}")
    private String accessKeyId;

    @Value("${aws_sicei_secret_access_key}")
    private String secretAccessKey;
    
    @Value("${aws_sicei_session_token}")
    private String awsSessionToken;

    @Value("${aws_sicei_region}")
    private String region;
 
    @Bean
    public AmazonS3 getAmazonS3Cient() {
        BasicSessionCredentials awsCredentials = new BasicSessionCredentials(accessKeyId, secretAccessKey, awsSessionToken);

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}

