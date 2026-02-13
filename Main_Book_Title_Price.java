import java.util.Scanner;
class Book {
    String title;
    double price;
    Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
    void displayDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Title : " + title);
        System.out.println("Price : " + price);
    }
}
public class Main_Book_Title_Price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter book price: ");
        double price = sc.nextDouble();
        Book b1 = new Book(title, price);   
        b1.displayDetails();
        sc.close();
    }
}
