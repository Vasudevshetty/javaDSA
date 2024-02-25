package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;

import dsa.stack.StackLL;

import javax.swing.JButton;

public class StackMenu extends JFrame {
    private JButton push, pop, peek;
    private JTextArea outputTextArea;
    private JTextField inputTextField;

    private StackLL<String> stack;

    public StackMenu() {
        super("Stack Menu");

        initComponents();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel buttons = new JPanel(new GridLayout(0, 3, 10, 10));
        buttons.add(push);
        buttons.add(pop);
        buttons.add(peek);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    private void initComponents() {
        push = new JButton("Push");
        pop = new JButton("Pop");
        peek = new JButton("Peek");
        stack = new StackLL<>();
        outputTextArea = new JTextArea("The output will be visible here.");
        inputTextField = new JTextField(15);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StackMenu());
    }
}
