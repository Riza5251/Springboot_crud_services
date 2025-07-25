package net.javaguides.Springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException{

    public String message;

    public EmailAlreadyExistException(String message)
    {
        super(message);
    }
}
