import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Streams {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner sc = new Scanner(new FileInputStream("test.txt"));

        final PrintWriter pw = new PrintWriter(
                new FileOutputStream("test.txt"));

        pw.println("Hello!");
        pw.flush();

        pw.println("Hello!");
        pw.flush();

        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}
