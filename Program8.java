import javax.swing.*;
import java.awt.event.*;

class Program8 extends JFrame implements ActionListener {

    JTextField principalField, rateField, timeField, resultField;
    JButton calculateBtn;

    Program8() {
        setTitle("Investment Calculator");
        setSize(300, 250);
        setLayout(null);

        JLabel l1 = new JLabel("Principal:");
        l1.setBounds(20, 20, 100, 20);
        add(l1);

        principalField = new JTextField();
        principalField.setBounds(120, 20, 120, 20);
        add(principalField);

        JLabel l2 = new JLabel("Rate (%):");
        l2.setBounds(20, 60, 100, 20);
        add(l2);

        rateField = new JTextField();
        rateField.setBounds(120, 60, 120, 20);
        add(rateField);

        JLabel l3 = new JLabel("Time (years):");
        l3.setBounds(20, 100, 100, 20);
        add(l3);

        timeField = new JTextField();
        timeField.setBounds(120, 100, 120, 20);
        add(timeField);

        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(80, 140, 120, 30);
        add(calculateBtn);

        JLabel l4 = new JLabel("Amount:");
        l4.setBounds(20, 180, 100, 20);
        add(l4);

        resultField = new JTextField();
        resultField.setBounds(120, 180, 120, 20);
        resultField.setEditable(false);
        add(resultField);

        calculateBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double p = Double.parseDouble(principalField.getText());
            double r = Double.parseDouble(rateField.getText());
            double t = Double.parseDouble(timeField.getText());

            double amount = p + (p * r * t) / 100;

            resultField.setText(String.valueOf(amount));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Program8();
    }
}