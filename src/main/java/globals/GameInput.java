package globals;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class GameInput {

    public Scanner scanner;

    public GameInput(PipedOutputStream out) throws IOException {
        InputStream in = new PipedInputStream(out);
        scanner = new Scanner(in);
    }

}