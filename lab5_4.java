import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class lab5_4 {

    public static void main(String[] args) {

        // สร้าง JFrame
        JFrame frame = new JFrame("Padsakorn Sukprasert 68160161 n36");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // สร้าง JTextArea
        JTextArea textArea = new JTextArea(8, 30);
        textArea.setWrapStyleWord(true);  // ตั้งค่าการจัดข้อความแบบพอดี
        textArea.setLineWrap(true); // ให้สามารถขึ้นบรรทัดใหม่ได้

        // ใส่ ScrollBar
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // สร้างเมนู
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFileSave = new JMenu("File");

        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemSaveAs = new JMenuItem("Save As");
        JMenuItem itemExit = new JMenuItem("Quit");

        // เพิ่มเมนูย่อย
        menuFileSave.add(itemNew);
        menuFileSave.add(itemOpen);
        menuFileSave.add(itemSave);
        menuFileSave.add(itemSaveAs);
        menuFileSave.addSeparator(); // เพิ่มบรรทัดคั่น
        menuFileSave.add(itemExit);

        // เพิ่มเมนูลงในเมนูบาร์
        menuBar.add(menuFileSave);
        frame.setJMenuBar(menuBar);

        // กิจกรรมสำหรับการคลิก New
        itemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // ล้างข้อความใน TextArea
            }
        });

        // กิจกรรมสำหรับการคลิก Open
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.setText(""); // ล้างข้อความใน TextArea
                        String line;
                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "ไม่สามารถอ่านไฟล์ได้", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // กิจกรรมสำหรับการคลิก Save
        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write(textArea.getText());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "ไม่สามารถบันทึกไฟล์ได้", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // กิจกรรมสำหรับการคลิก Save As
        itemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write(textArea.getText());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "ไม่สามารถบันทึกไฟล์ได้", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // กิจกรรมสำหรับการคลิก Quit
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // ออกจากโปรแกรม
            }
        });

        // แสดงหน้าต่าง
        frame.setVisible(true);
    }
}
