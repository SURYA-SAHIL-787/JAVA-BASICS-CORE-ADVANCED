public class CountInversions {
    public static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int count = 0;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                count += (n1 - i);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        int inversionCount = mergeSort(arr, 0, arr.length - 1);

        System.out.println("Number of inversions: " + inversionCount);
    }
}
