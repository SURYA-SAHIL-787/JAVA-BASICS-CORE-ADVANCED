import java.util.Scanner;

public class PrintStatements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first statement: ");
        String statement1 = sc.nextLine();

        System.out.print("Enter second statement: ");
        String statement2 = sc.nextLine();

        System.out.println("\nOutput:");
        System.out.println(statement1);
        System.out.println(statement2);

        sc.close();
    }
}
