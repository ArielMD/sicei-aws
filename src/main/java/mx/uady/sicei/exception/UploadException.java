package mx.uady.sicei.exception;

import com.amazonaws.AmazonServiceException;

public class UploadException extends AmazonServiceException {

    public UploadException(String errorMessage) {
        super(errorMessage);

    }
}
