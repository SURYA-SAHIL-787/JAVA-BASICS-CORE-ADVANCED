import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    void display() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Year  : " + year);
    }
}

class Library {
    private Book[] books;
    private int count;

    Library(int n) {
        books = new Book[n];
        count = 0;
    }

    void addBook(Book b) {
        if (count < books.length) {
            books[count++] = b;
        } else {
            System.out.println("Library is full!");
        }
    }

    void displayAll() {
        System.out.println("\n--- All Books ---");
        if (count == 0) {
            System.out.println("No books added.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            books[i].display();
        }
    }

    Book searchByTitle(String t) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(t)) {
                return books[i];
            }
        }
        return null;
    }
}

public class MainLibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Library lib = new Library(n);

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter Book " + i + " details:");
            System.out.print("Title : ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Year  : ");
            int year = sc.nextInt();
            sc.nextLine();

            lib.addBook(new Book(title, author, year));
        }

        lib.displayAll();

        System.out.print("\nEnter title to search: ");
        String search = sc.nextLine();
        Book found = lib.searchByTitle(search);

        if (found != null) {
            System.out.println("\nBook Found:");
            found.display();
        } else {
            System.out.println("\nBook not available!");
        }

        sc.close();
    }
}
