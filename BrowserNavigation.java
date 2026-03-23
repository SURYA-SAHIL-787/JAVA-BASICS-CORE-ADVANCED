import java.util.Stack;

public class BrowserNavigation {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public BrowserNavigation() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = "HOME";
    }

    // VISIT NEW PAGE
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
    }

    // GO BACK
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        } else {
            System.out.println("NO PAGE IN BACK HISTORY");
        }
    }

    // GO FORWARD
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        } else {
            System.out.println("NO PAGE IN FORWARD HISTORY");
        }
    }

    // DISPLAY CURRENT PAGE
    public void showCurrentPage() {
        System.out.println("CURRENT PAGE: " + currentPage);
    }

    public static void main(String[] args) {
        BrowserNavigation browser = new BrowserNavigation();

        browser.showCurrentPage();

        browser.visit("GOOGLE.COM");
        browser.showCurrentPage();

        browser.visit("YOUTUBE.COM");
        browser.showCurrentPage();

        browser.visit("GITHUB.COM");
        browser.showCurrentPage();

        browser.back();
        browser.showCurrentPage();

        browser.back();
        browser.showCurrentPage();

        browser.forward();
        browser.showCurrentPage();
    }
}
