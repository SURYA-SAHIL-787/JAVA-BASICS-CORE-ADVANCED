public class LibraryManagement {

    static class Book {
        protected String title;
        protected String author;
        protected boolean issued;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.issued = false;
        }

        public void issueBook() {
            if (!issued) {
                issued = true;
                System.out.println(title + " issued successfully.");
            } else {
                System.out.println(title + " is already issued.");
            }
        }

        public void returnBook(int lateDays) {
            if (issued) {
                issued = false;
                System.out.println(title + " returned.");
                System.out.println("Late fee: ₹" + calculateLateFee(lateDays));
            } else {
                System.out.println(title + " was not issued.");
            }
        }

        public double calculateLateFee(int lateDays) {
            return lateDays * 2.0;
        }

        public void display() {
            System.out.println("Book: " + title + " | Author: " + author + " | Issued: " + issued);
        }
    }

    static class EBook extends Book {
        public EBook(String title, String author) {
            super(title, author);
        }

        @Override
        public double calculateLateFee(int lateDays) {
            return 0; // No late fee for e-books
        }
    }

    static class PrintedBook extends Book {
        public PrintedBook(String title, String author) {
            super(title, author);
        }

        @Override
        public double calculateLateFee(int lateDays) {
            return lateDays * 5.0;
        }
    }

    public static void main(String[] args) {
        Book b1 = new PrintedBook("Java Complete Reference", "Herbert Schildt");
        Book b2 = new EBook("Clean Code PDF", "Robert C. Martin");

        b1.display();
        b2.display();

        b1.issueBook();
        b2.issueBook();

        b1.returnBook(4);
        b2.returnBook(4);
    }
}
