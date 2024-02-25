package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dsa.list.DoubleCircularLinkedList;
import dsa.list.Exception.EmptyLinkedListException;

public class ListMenu extends JFrame {
    private JTextField dataField;
    private JLabel instructionLabel;
    private JTextArea outputArea;
    private JButton[] buttons;
    private DoubleCircularLinkedList<String> list;

    public ListMenu() {
        super("Linked List Operations");

        this.initaliseComponents();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel inputOutputPanel = createInputPanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        this.add(inputOutputPanel, constraints);

        JPanel buttonPanel = createButtonPanel();
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(buttonPanel, constraints);

        this.setSize(500, 500);
        this.setMaximumSize(this.getSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initaliseComponents() {
        dataField = new JTextField("", 15);
        instructionLabel = new JLabel("Enter the operation: ");
        outputArea = new JTextArea("Your output will be displayed here.");
        buttons = new JButton[11];
        list = new DoubleCircularLinkedList<>();

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

        outputArea.setEditable(false);
        outputArea.setWrapStyleWord(true);
        outputArea.setLineWrap(true);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        constraints.weightx = 1.0;
        inputOutputPanel.add(outputArea, constraints);
        return inputOutputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(new ButtonListener());
            constraints.gridx = i % 2;
            constraints.gridy = i / 2;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.ipadx = 20;
            constraints.ipady = 10;
            constraints.insets = new Insets(5, 10, 5, 10);
            buttonPanel.add(buttons[i], constraints);
        }

        return buttonPanel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = ((JButton) e.getSource()).getText();
            handleMenu(source);
        }
    }

    private void handleMenu(String source) {
        String data;
        int position;

        switch (source) {
            case "Insert At Head":
                data = dataField.getText().trim();
                if (!data.isEmpty()) {
                    instructionLabel.setText("Enter data : ");
                    list.insertHead(data);
                    handleMenu("Display");
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Insert At Tail":
                data = dataField.getText().trim();
                if (!data.isEmpty()) {
                    instructionLabel.setText("Enter data : ");
                    list.insertTail(data);
                    this.handleMenu("Display");
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Insert At Specific Position":
                data = dataField.getText().trim();
                if (!data.isEmpty()) {
                    instructionLabel.setText("Enter position : ");
                    position = Integer.parseInt(data);
                    instructionLabel.setText("Enter data : ");
                    data = dataField.getText().trim();
                    if (!data.isEmpty()) {
                        list.insert(data, position);
                        this.handleMenu("Display");
                    } else {
                        JOptionPane.showMessageDialog(this, "Please enter valid data.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid position.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Delete At Head":
                try {

                    list.deleteHead();
                } catch (EmptyLinkedListException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                this.handleMenu("Display");
                break;
            case "Delete At Tail":
                try {

                    list.deleteTail();
                } catch (EmptyLinkedListException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                this.handleMenu("Display");
                break;
            case "Delete At Specific Position":
                data = dataField.getText().trim();
                if (!data.isEmpty()) {
                    position = Integer.parseInt(data);
                    try {
                        list.delete(position);
                    } catch (EmptyLinkedListException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    this.handleMenu("Display");
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid position.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Delete key":
                data = dataField.getText().trim();
                if (!data.isEmpty()) {
                    try {
                        list.deleteBykey(data);
                    } catch (EmptyLinkedListException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    this.handleMenu("Display");
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid key.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Search Key":
                data = dataField.getText().trim();
                if (!data.isEmpty()) {
                    list.searchByKey(data);
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid key.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                break;
            case "Reverse":
                try {
                    list.reverse();
                } catch (EmptyLinkedListException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                this.handleMenu("Display");
                break;
            case "Copy":
                @SuppressWarnings("Unchecked")
                DoubleCircularLinkedList<String> copy = new DoubleCircularLinkedList<>();
                try {

                    copy = (DoubleCircularLinkedList<String>) list.copyList();
                } catch (EmptyLinkedListException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                this.handleMenu(copy.toString());
                break;
            case "Display":
                try {
                    outputArea.setText(list.toString());
                } catch (EmptyLinkedListException e) {
                    JOptionPane.showMessageDialog(this, "Empty list cannot be displayed");
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListMenu::new);
    }
}