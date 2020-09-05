package root.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame {

    private int width;
    private int height;
    private JButton button;
    private MyActionListener myActionListener;

    public TestFrame(int width, int height) throws HeadlessException {
        this.width = width;
        this.height = height;
        this.button = new JButton("CLICK ME");
        this.myActionListener = new MyActionListener();
    }

    public void setUpGUI() {
        setSize(width, height);
        setTitle("Swingy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(button);
        button.addActionListener(myActionListener);
        setVisible(true); // always last
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button was clicked");
        }

    }

}
