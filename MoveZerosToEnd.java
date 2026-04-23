import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {4, 0, 7, 0, 1, 9, 0, 3};

        int index = 0;

        // Place all non-zero elements first
        for (int num : arr) {
            if (num != 0) {
                arr[index] = num;
                index++;
            }
        }

        // Fill remaining positions with 0
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }

        System.out.println("Array after moving zeros to end: " + Arrays.toString(arr));
    }
}
