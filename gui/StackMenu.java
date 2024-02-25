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

import dsa.stack.StackArray;
import dsa.stack.Exception.StackUnderflowException;

import javax.swing.JButton;

public class StackMenu extends JFrame {
    private JButton push, pop, peek;
    private JTextArea outputTextArea;
    private JTextField inputTextField;

    private StackArray<String> stack;

    String data;

    public StackMenu() {
        super("Stack Menu");

        initComponents();
        setupLayout();

        push.addActionListener((ActionEvent e) -> {
            data = inputTextField.getText().trim();
            if (!data.isEmpty()) {
                stack.push(data);
                this.updateOutput();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter valid data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        pop.addActionListener((ActionEvent e) -> {
            if (stack.isEmpty())
                JOptionPane.showMessageDialog(this, "Stack Empty, no elements to pop.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            try {
                stack.pop();
                updateOutput();
            } catch (StackUnderflowException ex) {
                outputTextArea.setText(ex.getMessage());
            }
        });

        peek.addActionListener((ActionEvent e) -> {
            if (stack.isEmpty())
                JOptionPane.showMessageDialog(this, "Stack empty, no elements to peek.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            else
                outputTextArea.setText("The top(peeked) element of the stack is " + stack.peek());
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    private void initComponents() {
        push = new JButton("Push");
        pop = new JButton("Pop");
        peek = new JButton("Peek");
        stack = new StackArray<>();
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
        inputTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StackMenu());
    }
}
