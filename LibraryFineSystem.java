class LibraryItem {
    private String title;
    private int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public double calculateFine() {
        return 0;
    }
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 2;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 3.5;
    }
}

public class LibraryFineSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book("Java Basics", 4);
        LibraryItem item2 = new Magazine("Tech Monthly", 4);

        System.out.println(item1.getTitle() + " Fine: " + item1.calculateFine());
        System.out.println(item2.getTitle() + " Fine: " + item2.calculateFine());
    }
}
