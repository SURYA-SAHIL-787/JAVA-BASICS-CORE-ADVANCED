import java.util.Scanner;

class DuplicateCharacters {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int count;

        System.out.println("Duplicate characters are:");

        for (int i = 0; i < str.length(); i++) {
            count = 1;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && str.charAt(i) != ' ') {
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(str.charAt(i));
            }
        }

        sc.close();
    }
}
