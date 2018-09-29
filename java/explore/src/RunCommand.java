import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * javac -d compile src/RunCommand.java
 * java -cp compile RunCommand
 */
public class RunCommand {

    public static void main(String[] args) throws IOException {
        final RunCommand runCommand = new RunCommand();
        runCommand.execute("ls -ltr");

        // Shell variables are not expanded, probably because the profile/bashrc is not loaded?
        runCommand.execute("echo $PWD");
    }

    private void execute(String command) throws IOException {
        final Process exec = Runtime.getRuntime().exec(command);

        final InputStream inputStream = exec.getInputStream();
        final Scanner scanner = new Scanner(inputStream);

        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
