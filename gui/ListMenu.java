package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListMenu extends JFrame {
    private JTextField dataField;
    private JLabel instructionLabel;
    private JLabel outputLabel;
    private JButton[] buttons;

    public ListMenu() {
        super("Linked List Operations");

        this.initaliseComponents();

        this.setLayout(new GridLayout());

        this.setSize(500, 500);
        this.setMaximumSize(this.getSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initaliseComponents() {
        dataField = new JTextField(15);
        instructionLabel = new JLabel("Enter the operation: ");
        outputLabel = new JLabel("Your output will be displayed here.");
        buttons = new JButton[11];

        buttons[0] = new JButton("Insert At Head");
        buttons[1] = new JButton("Insert At Tail");
        buttons[2] = new JButton("Insert At Specific Position");
        buttons[3] = new JButton("Delete At Head");
        buttons[4] = new JButton("Delete At Tail");
        buttons[5] = new JButton("Delete At Specific Position");
        buttons[6] = new JButton("Search Key");
        buttons[7] = new JButton("Delete Key");
        buttons[8] = new JButton("Reverse");
        buttons[9] = new JButton("Copy");
        buttons[10] = new JButton("Display");

    }

}