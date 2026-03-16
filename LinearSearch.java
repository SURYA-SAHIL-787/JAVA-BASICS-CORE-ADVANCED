public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 5};
        int target = 9;
        System.out.println("Index: " + linearSearch(arr, target));
    }
}
