import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * javac -d compile src/FileTest.java
 * java -cp resources:compile FileTest
 */
public class FileTest {

    public static void main(String args[]) throws IOException {
        final InputStream resource = FileTest.class.getResourceAsStream("fruits.txt");

        final FileInputStream fileInputStream = new FileInputStream("/home/binu/playground/dojo/java/explore/resources/fruits.txt");
        readFile(resource);
        readFile(fileInputStream);
    }

    private static void readFile(InputStream inputStream) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        int c;
        while ((c = inputStreamReader.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
