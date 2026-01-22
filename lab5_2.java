import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class lab5_2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Program with JTextArea");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextArea textArea = new JTextArea(8, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton buttonShowMessage = new JButton("Show message");
        JButton buttonSave = new JButton("Save");

        buttonShowMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                JOptionPane.showMessageDialog(frame, text,
                        "Your message: ", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String text = textArea.getText();

                String filePath = "D:\\message.txt";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write(text);
                    JOptionPane.showMessageDialog(frame, "Message saved successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving message: " + ex.getMessage());
                }
            }
        });

        frame.setLayout(new BorderLayout());

        JPanel panelButtons = new JPanel();
        panelButtons.add(buttonSave);
        panelButtons.add(buttonShowMessage);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
