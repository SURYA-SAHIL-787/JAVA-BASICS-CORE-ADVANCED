public class GreaterThanAverage {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 15, 25};

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        double average = (double) sum / arr.length;
        int count = 0;

        for (int num : arr) {
            if (num > average) {
                count++;
            }
        }

        System.out.println("Average: " + average);
        System.out.println("Elements greater than average: " + count);
    }
}
