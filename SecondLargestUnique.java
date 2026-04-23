public class SecondLargestUnique {
    public static void main(String[] args) {
        int[] arr = {12, 45, 67, 45, 89, 89, 23};

        Integer largest = null;
        Integer secondLargest = null;

        for (int num : arr) {
            if (largest == null || num > largest) {
                if (largest == null || num != largest) {
                    secondLargest = largest;
                    largest = num;
                }
            } else if (num != largest && (secondLargest == null || num > secondLargest)) {
                secondLargest = num;
            }
        }

        if (secondLargest != null) {
            System.out.println("Second largest unique element: " + secondLargest);
        } else {
            System.out.println("No second largest unique element found.");
        }
    }
}
