package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

import dsa.stack.StackLL;

import javax.swing.JButton;

public class StackMenu extends JFrame {
    private JButton push, pop, peek;
    private JTextArea outputTextArea;
    private JTextField inputTextField;

    private StackLL<String> stack;

    String data;

    public StackMenu() {
        super("Stack Menu");

        initComponents();
        setupLayout();


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
        outputTextArea.setEditable(false);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setLineWrap(true);
        inputTextField = new JTextField(15);
    }

    private void setupLayout() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(inputTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        this.add(outputTextArea, constraints);

        JPanel buttons = new JPanel(new GridLayout(0, 3, 10, 10));
        buttons.add(push);
        buttons.add(pop);
        buttons.add(peek);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        this.add(buttons, constraints);
    }

    private void updateOutput() {
        outputTextArea.setText(stack.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StackMenu());
    }
}
