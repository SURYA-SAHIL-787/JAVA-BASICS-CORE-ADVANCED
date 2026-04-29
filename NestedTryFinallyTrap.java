public class NestedTryFinallyTrap {
    public static int test() {
        try {
            try {
                int x = 10 / 0;
                return 1;
            } catch (NullPointerException e) {
                return 2;
            } finally {
                return 3;
            }
        } catch (ArithmeticException e) {
            return 4;
        } finally {
            System.out.println("Outer finally executed");
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
