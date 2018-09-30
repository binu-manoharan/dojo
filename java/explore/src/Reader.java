import java.io.*;
import java.net.URL;

public class Reader {
    public static void main(String[] args) throws IOException {
        final URL resource = Reader.class.getClassLoader().getResource("fruits.txt");
        readUsingBufferedReader(resource);
        readUsingStringReader();
        readUsingLineNumberReader(resource);
    }

    private static void printHeader(String header) {
        System.out.println();
        System.out.println("===============================");
        System.out.println(header);
        System.out.println("===============================");
        System.out.println();
    }

    private static void readUsingLineNumberReader(URL resource) throws IOException {
        printHeader("Line number reader");
        InputStream inputStream = resource.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
        String line;
        while ((line = lineNumberReader.readLine()) != null) {
            System.out.println(lineNumberReader.getLineNumber() + " " + line);
        }
    }

    private static void readUsingStringReader() throws IOException {
        printHeader("String reader");
        final StringReader stringReader = new StringReader("hello string reader!\n");
        int charRead;
        while((charRead = stringReader.read()) != -1) {
            System.out.print((char) charRead);
        }
    }

    private static void readUsingBufferedReader(URL resource) throws IOException {
        printHeader("Buffered reader");
        final InputStream inputStream = resource.openStream();
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        final char[] buffer = new char[3];
        while((bufferedReader.read(buffer, 0, 3)) != -1) {
            System.out.println(buffer);
        }
    }
}
