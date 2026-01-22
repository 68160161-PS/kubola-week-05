import javax.swing.*;

public class lab5_1 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI with Menu");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCalculate = new JMenu("Calculate");
        JMenu menuOther = new JMenu("Others");

        JMenuItem itemAdd = new JMenuItem("Add");
        JMenuItem itemSub = new JMenuItem("Subtract");
        JMenuItem itemMultiply = new JMenuItem("Multiply");  // เมนูใหม่
        JMenuItem itemName = new JMenuItem("Greeting");
        JMenuItem itemExit = new JMenuItem("Quit");

        menuCalculate.add(itemAdd);
        menuCalculate.add(itemSub);
        menuCalculate.add(itemMultiply);  // เพิ่มเมนู Multiply

        menuOther.add(itemName);
        menuOther.addSeparator();
        menuOther.add(itemExit);

        menuBar.add(menuCalculate);
        menuBar.add(menuOther);

        frame.setJMenuBar(menuBar);

        itemAdd.addActionListener(e -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Adding result = " + (a + b));
        });

        itemSub.addActionListener(e -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Subtract result = " + (a - b));
        });

        itemMultiply.addActionListener(e -> {  // เพิ่ม action สำหรับ Multiply
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Multiplying result = " + (a * b));
        });

        itemName.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter name");
            JOptionPane.showMessageDialog(frame, "Hello " + name);
        });

        itemExit.addActionListener(e -> {
            System.exit(0);
        });

        frame.setVisible(true);
    }
}
