package warsztaty.java.ailleronLab.exceptions.handler;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
