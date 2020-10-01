package root.view;

import globals.GameInput;
import globals.Globals;
import root.App;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Gui extends JFrame {

    public static GameInput gameInput;
    public static PrintStream myPrintStream;
    final JTextField textField = new JTextField(20);

    public void setUpGUI() throws IOException {
        setSize(1280, 720);
        setTitle("Swingy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout());

        ////////////////////////////////////////////system.out
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output));
        myPrintStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                output.append(""+(char)(b & 0xFF));
            }
        });
        System.setOut(myPrintStream);
        ////////////////////////////////////////////system.out

        ////////////////////////////////////////////system.in
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PrintWriter writer = new PrintWriter(pipedOutputStream);
        gameInput = new GameInput(pipedOutputStream);

        final JButton button = new JButton("submit");
        button.addActionListener(e -> {
            String data = textField.getText();
            writer.println(data);
            writer.flush();
        });
        ////////////////////////////////////////////system.in

        ////////////////////////////////////////////switch console/gui
        final JButton consoleButton = new JButton("console");
        consoleButton.addActionListener(e -> {
            Globals.gameMode = "console";
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            System.out.println("You may now switch to console on next turn");
            //setVisible(false);
        });
        ////////////////////////////////////////////switch console/gui

        add(textField);
        add(button);
        add(consoleButton);

        setVisible(true); // always last
    }

    public String getInput() {
        String text = gameInput.scanner.nextLine();
        textField.setText("");
        return text;
    }

    public static void setOutput(PrintStream printStream) {
        System.setOut(myPrintStream);
    }

}

