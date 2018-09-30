import java.io.*;
import java.net.URL;

public class Reader {
    public static void main(String[] args) throws IOException {
        final URL resource = Reader.class.getClassLoader().getResource("fruits.txt");
        final InputStream inputStream = resource.openStream();
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        // Buffered reader
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        final char[] buffer = new char[3];
        while((bufferedReader.read(buffer, 0, 3)) != -1) {
            System.out.println(buffer);
        }

        // String reader
        final StringReader stringReader = new StringReader("hello string reader!\n");
        int c;
        while((c = stringReader.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
