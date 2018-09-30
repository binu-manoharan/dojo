import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        final URL resource = ReadFile.class.getClassLoader().getResource("fruits.txt");
        final List<String> strings = Files.readAllLines(Paths.get(resource.getFile()));

        strings.forEach(System.out::println);
    }
}
