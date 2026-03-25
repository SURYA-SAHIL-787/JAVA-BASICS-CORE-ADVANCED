import java.util.Scanner;

class ArrayIndexHandling {
    public static void main(String[] args) {
        
        // CREATE SCANNER OBJECT FOR USER INPUT
        Scanner sc = new Scanner(System.in);

        // CREATE ARRAY
        int[] arr = {10, 20, 30, 40, 50};

        // DISPLAY VALID INDEX RANGE
        System.out.println("Array elements are: 10 20 30 40 50");
        System.out.print("Enter index to access: ");
        int index = sc.nextInt();

        try {
            // ACCESS ARRAY ELEMENT
            System.out.println("Element at index " + index + " = " + arr[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // HANDLE INVALID INDEX
            System.out.println("ERROR: Array index is out of bounds!");
        }

        // CLOSE SCANNER
        sc.close();
    }
}