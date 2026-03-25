import java.util.Scanner;
public class NumberProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of inputs:");
        int n = sc.nextInt();
        String[] inputs = new String[n];
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            inputs[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            try {
                int num = Integer.parseInt(inputs[i]);
                System.out.println("Valid number: " + num);
            } catch (Exception e) {
                System.out.println("Invalid input: " + inputs[i]);
            }
        }
        sc.close();
    }
}



