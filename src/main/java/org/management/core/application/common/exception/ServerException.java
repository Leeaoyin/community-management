package org.management.core.application.common.exception;

public class ServerException extends RuntimeException{

    public ServerException(String msg){
        super(msg);
    }
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
