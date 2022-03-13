package africa.semicolon.phoneBookTech.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String msg){
        super(msg);
    }
}
