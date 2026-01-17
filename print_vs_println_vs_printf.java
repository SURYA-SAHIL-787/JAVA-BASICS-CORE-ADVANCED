public class print_vs_println_vs_printf {
    public static void main (String[]args)
    {
    // (println) : (Prints The Text And Then Moves The Cursor To The Next Line)
        System.out.println("1 2 3 4 5");
    // (print) : (Prints The Text Without Moving To A New Line)
        System.out.print("1 ");
        System.out.print("2 ");
        System.out.print("3 ");
        System.out.print("4 ");
        System.out.print("5");
         System.out.println();
    // pintf : print formatted
    // > How Values Are Displayed Using Format Specifiers Like  (%d): 
        System.out.printf("%d %d %d %d %d" ,1, 2, 3, 4, 5);
    }
}
