import java.util.*;

class InvalidArrayException extends Exception {
    InvalidArrayException(String msg) {
        super(msg);
    }
}

class MergeSorter extends Thread {
    private int[] arr;
    private int left, right;

    MergeSorter(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    public void run() {
        mergeSort(arr, left, right);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;

        Thread leftThread = new MergeSorter(arr, l, mid);
        Thread rightThread = new MergeSorter(arr, mid + 1, r);

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];

        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }
}

public class ParallelMergeSort {
    public static void validateArray(int[] arr) throws InvalidArrayException {
        if (arr == null || arr.length == 0) {
            throw new InvalidArrayException("Array cannot be null or empty");
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 1, 3, 8, 2, 6, 5};

        try {
            validateArray(arr);

            MergeSorter sorter = new MergeSorter(arr, 0, arr.length - 1);
            sorter.start();
            sorter.join();

            System.out.println(Arrays.toString(arr));
        } catch (InvalidArrayException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
