public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i]; // now totalSum becomes right sum

            if (leftSum == totalSum) {
                System.out.println("Equilibrium index found at: " + i);
                found = true;
                break;
            }

            leftSum += arr[i];
        }

        if (!found) {
            System.out.println("No equilibrium index found.");
        }
    }
}
