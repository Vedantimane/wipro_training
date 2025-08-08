package aopdemo.airmanagement.expections;

public class NoSeatAvailableException extends Exception {
    public NoSeatAvailableException(String message) {
        super(message);
    }
}
