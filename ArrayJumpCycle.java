public class ArrayJumpCycle {
    public static boolean hasCycle(int[] arr) {
        int slow = 0;
        int fast = 0;

        while (fast >= 0 && fast < arr.length) {
            slow = nextIndex(arr, slow);

            fast = nextIndex(arr, fast);
            if (fast == -1) return false;
            fast = nextIndex(arr, fast);

            if (slow == -1 || fast == -1) return false;

            if (slow == fast) return true;
        }

        return false;
    }

    private static int nextIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) return -1;
        int next = index + arr[index];
        if (next < 0 || next >= arr.length) return -1;
        return next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, -1, 2, -2};
        System.out.println("Cycle exists: " + hasCycle(arr));
    }
}
