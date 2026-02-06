import java.util.Scanner;
class Book {
    String title, author;
    int year;
    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
class Library {
    Book[] books;
    int count = 0;
    Library(int n) {
        books = new Book[n];
    }
    void addBook(Book b) {
        if (count < books.length) books[count++] = b;
    }
    Book searchByTitle(String t) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equals(t)) return books[i]; 
        }
        return null;
    }
}
public class MainLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        Library lib = new Library(n);
        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter Book " + i + " details:");
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Year: ");
            int year = sc.nextInt();
            sc.nextLine(); 
            lib.addBook(new Book(title, author, year));
        }
        System.out.print("\nEnter title to search: ");
        String searchTitle = sc.nextLine();
        Book found = lib.searchByTitle(searchTitle);
        if (found != null) {
            System.out.println("\nBook Found :");
            System.out.println("Title : " + found.title);
            System.out.println("Author: " + found.author);
            System.out.println("Year  : " + found.year);
        } else {
            System.out.println("\nBook Not Found ");
        }
        sc.close();
    }
}
