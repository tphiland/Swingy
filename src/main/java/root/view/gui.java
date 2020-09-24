package root.view;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class gui extends JFrame {

    public void setUpGUI() {
        setSize(1280, 720);
        setTitle("Swingy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output));

        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                output.append(""+(char)(b & 0xFF));
            }
        });
        System.setOut(printStream);

        setVisible(true); // always last
    }

}

