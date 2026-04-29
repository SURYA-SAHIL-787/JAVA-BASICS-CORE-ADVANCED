import java.io.IOException;

public class MultiCatchRethrow {
    static void risky(int value) throws IOException {
        try {
            if (value == 1) {
                throw new IOException("IO error");
            } else {
                throw new NumberFormatException("Number format error");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Caught: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            risky(1);
        } catch (IOException e) {
            System.out.println("Handled IOException");
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException");
        }
    }
}
