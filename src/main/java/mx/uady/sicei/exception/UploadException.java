package mx.uady.sicei.exception;

import com.amazonaws.AmazonServiceException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UploadException extends AmazonServiceException {

    public UploadException(String errorMessage) {
        super(errorMessage);

    }
}
