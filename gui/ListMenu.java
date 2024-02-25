package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ListMenu extends JFrame {
    private JTextField dataField;
    private JLabel instructionLabel;
    private JLabel outputLabel;
    private JButton[] buttons;

    public ListMenu() {
        super("Linked List Operations");

        this.initaliseComponents();

        this.setLayout(new GridLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        JPanel inputOutputPanel = createInputPanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        this.add(inputOutputPanel, constraints);

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

    private JPanel createInputPanel() {
        JPanel inputOutputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 5, 10);
        inputOutputPanel.add(instructionLabel, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(0, 10, 10, 10);
        inputOutputPanel.add(dataField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        inputOutputPanel.add(outputLabel, constraints);
        return inputOutputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListMenu::new);
    }
}