import java.util.Scanner;

class HelloThread extends Thread {
    String text;
    int times;

    HelloThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    public void run() {
        for (int i = 1; i <= times; i++) {
            System.out.println(text);
        }
    }
}

class WorldThread extends Thread {
    String text;
    int times;

    WorldThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    public void run() {
        for (int i = 1; i <= times; i++) {
            System.out.println(text);
        }
    }
}

public class HelloWorldThreads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String word1 = sc.nextLine();

        System.out.print("Enter second word: ");
        String word2 = sc.nextLine();

        System.out.print("Enter number of times to print: ");
        int times = sc.nextInt();

        HelloThread t1 = new HelloThread(word1, times);
        WorldThread t2 = new WorldThread(word2, times);

        t1.start();
        t2.start();

        sc.close();
    }
}