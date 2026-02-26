abstract class Report {
    public final void generate() {        // fixed steps
        readData();
        process();
        print();
    }
    abstract void readData();
    abstract void process();
    void print(){ System.out.println("Printing report"); }
}

class SalesReport extends Report {
    void readData(){ System.out.println("Read sales data"); }
    void process(){ System.out.println("Process totals"); }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Report r = new SalesReport();
        r.generate();
    }
}
