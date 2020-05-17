package ro.ubb.catalog.core.model.exceptions;

public class ServerClientException extends RuntimeException {
    public ServerClientException(String errorMsg){
        super(errorMsg);
    }

    public ServerClientException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }
}
