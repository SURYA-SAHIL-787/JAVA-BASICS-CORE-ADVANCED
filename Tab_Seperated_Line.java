import java.util.Scanner;

public class Tab_Seperated_Line {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String1");
        String name1 = sc.nextLine();
        System.out.println("Enter String2");
        String name2 = sc.nextLine();
        System.out.println("Enter String3");
        String name3 = sc.nextLine();

        System.out.println(name1 + "\t" + name2 + "\t" + name3);

        sc.close();
    }
}
