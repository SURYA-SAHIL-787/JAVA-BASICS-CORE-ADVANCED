import java.io.*;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        int key = 3;

        encryptFile("plain.txt", "encrypted.txt", key);
        decryptFile("encrypted.txt", "decrypted.txt", key);

        System.out.println("Encryption and Decryption completed.");
    }

    static void encryptFile(String input, String output, int key) {
        try {
            FileReader fr = new FileReader(input);
            FileWriter fw = new FileWriter(output);

            int ch;

            while ((ch = fr.read()) != -1) {
                fw.write(ch + key);
            }

            fr.close();
            fw.close();

        } catch (IOException e) {
            System.out.println("Encryption error: " + e.getMessage());
        }
    }

    static void decryptFile(String input, String output, int key) {
        try {
            FileReader fr = new FileReader(input);
            FileWriter fw = new FileWriter(output);

            int ch;

            while ((ch = fr.read()) != -1) {
                fw.write(ch - key);
            }

            fr.close();
            fw.close();

        } catch (IOException e) {
            System.out.println("Decryption error: " + e.getMessage());
        }
    }
}
