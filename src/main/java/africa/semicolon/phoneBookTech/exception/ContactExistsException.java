package africa.semicolon.phoneBookTech.exception;

public class ContactExistsException extends RuntimeException{
    public ContactExistsException(String msg){
        super(msg);
    }
}

