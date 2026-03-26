import java.util.Scanner;
class MultipleExceptionHandling {
    public static void main(String[] args) {
        // CREATE SCANNER OBJECT
        Scanner sc = new Scanner(System.in);
        try {
            // TAKE INPUT FROM USER
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            // PERFORM DIVISION
            int result = a / b;
            // DISPLAY RESULT
            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e) {
            // HANDLE DIVISION BY ZERO
            System.out.println("ERROR: Cannot divide by zero!");
        }
        catch (Exception e) {
            // HANDLE INVALID INPUT (LIKE STRING)
            System.out.println("ERROR: Invalid input! Please enter integers only.");
        }
        finally {
            // ALWAYS EXECUTES
            System.out.println("PROGRAM EXECUTED.");
            sc.close();
        }
    }
}
