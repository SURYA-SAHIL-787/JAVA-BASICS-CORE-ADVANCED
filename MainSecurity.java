import java.util.Scanner;
final class SecurityHelper {
    void checkAccess(String code) {
        if (code.equals("ADMIN123")) {
            System.out.println("ACCESS GRANTED.");
        } else {
            System.out.println("ACCESS DENIED.");
        }
    }
}
public class MainSecurity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER SECURITY CODE: ");
        String code = sc.nextLine();
        SecurityHelper s = new SecurityHelper();
        s.checkAccess(code);
        sc.close();
    }
}
