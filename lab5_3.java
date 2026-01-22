import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class lab5_3 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Save File with JFileChooser");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");


        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        PrintWriter writer = new PrintWriter(file);
                        writer.write(textArea.getText());
                        writer.close();

                        JOptionPane.showMessageDialog(frame,
                                "Save file successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Error. Unable to save file.");
                    }
                }
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // จัด Layout ของ Frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        // แสดงหน้าจอ
        frame.setVisible(true);
    }
}
