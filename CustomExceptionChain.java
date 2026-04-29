class InvalidAgeException extends Exception {
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class CustomExceptionChain {
    static void validateAge(int age) throws InvalidAgeException {
        try {
            if (age < 18) {
                throw new IllegalArgumentException("Age below 18");
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidAgeException("Validation failed", e);
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        }
    }
}
