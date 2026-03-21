public class PalindromePartitioningII {

    public static int minCut(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                   (end - start <= 2 || palindrome[start + 1][end - 1])) {

                    palindrome[start][end] = true;

                    if (start == 0) {
                        cuts[end] = 0;
                    } else {
                        cuts[end] = Math.min(cuts[end], cuts[start - 1] + 1);
                    }
                }
            }
        }

        return cuts[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
