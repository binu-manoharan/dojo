import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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

        final Path path = Paths.get("/home/binu/playground/dojo/java/explore/");
        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void readFile(InputStream inputStream) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        int c;
        while ((c = inputStreamReader.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
