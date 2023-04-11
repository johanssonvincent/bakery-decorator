package se.umu.cs.apjava.bakery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class BakeryGuiBuilder {

        private BakeryViewModel bakeryViewModel;
        void buildGui() {
        bakeryViewModel = new BakeryViewModel();
        var frame=new JFrame();
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        var cakePanel=new JPanel();
        JTextArea textArea = new JTextArea();

        /* Create buttons to order and print order */
        var orderButton = new JButton("Add to order");
        orderButton.addActionListener(e-> {
            JDialog options = setUpOptionsWindow(frame);
            options.setVisible(true);
        });
        var printButton=new JButton("Print Order");
        printButton.addActionListener(e->{
            String orderString=bakeryViewModel.printOrder();
            textArea.append(orderString);
        });
        cakePanel.add(orderButton);
        cakePanel.add(printButton);

        /* Add components to frame and make it visible */
        frame.add(cakePanel,BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Configure and return a JDialog window where the user can choose which type of cake they wish to order
     * @param mainFrame the programs main window frame
     * @return A configured JDialog object
     */
    private JDialog setUpOptionsWindow(JFrame mainFrame) {
        /* Create a new JDialog with the main frame as parent */
        JDialog optionsDialog = new JDialog(mainFrame, "New order", true);
        optionsDialog.setSize(400, 400);
        optionsDialog.setLocationRelativeTo(mainFrame);
        optionsDialog.setLayout(new BoxLayout(optionsDialog.getContentPane(), BoxLayout.Y_AXIS));

        /*
         * Create a new JPanel containing dropdown list
         * with cake types and add it to the JDialog
         */
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Cake type");
        String[] cakeTypes = {"Chocolate", "Vanilla", "Strawberry"};
        JComboBox<String> cakeTypeList = new JComboBox<>(cakeTypes);
        cakeTypeList.setPreferredSize(new Dimension(200, 20));
        cakeTypeList.setMaximumSize(cakeTypeList.getPreferredSize());
        typePanel.add(label);
        typePanel.add(cakeTypeList);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        cakeTypeList.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*
        * Add extras options in form of checkboxes
        * TextField at the end to add a message to the cake
        */
        JPanel extrasPanel = new JPanel();
        extrasPanel.setLayout(new BoxLayout(extrasPanel, BoxLayout.Y_AXIS));
        JCheckBox sprinkleBox = new JCheckBox("Sprinkles");
        JCheckBox extraLargeBox = new JCheckBox("Extra Large");
        JCheckBox textBox = new JCheckBox("Decorative text");
        JTextField textField = new JTextField("Enter desired text here"); /* Used to specify decor text */
        /* Add FocusListener to clear text when user clicks the TextField */
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing
            }
        });
        textField.setPreferredSize(new Dimension(300, 20));
        textField.setMaximumSize(textField.getPreferredSize());
        extrasPanel.add(sprinkleBox);
        extrasPanel.add(extraLargeBox);
        extrasPanel.add(textBox);
        extrasPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        extrasPanel.add(textField);
        sprinkleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        extraLargeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        textBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton placeOrder = new JButton("Place order");
        /* Setup ActionListener for placeOrder button */
        placeOrder.addActionListener(e->{
            boolean sprinkles = sprinkleBox.isSelected();
            boolean extraLarge = extraLargeBox.isSelected();
            boolean addedText = textBox.isSelected();
            Cake orderedCake = null;
            switch (Objects.requireNonNull(cakeTypeList.getSelectedItem()).toString()) {
                case "Chocolate":
                    orderedCake = new ChocolateCake();
                    if (sprinkles) orderedCake = new Sprinkles(orderedCake);
                    if (extraLarge) orderedCake = new ExtraLarge(orderedCake);
                    if (addedText) orderedCake = new DecorText(orderedCake, textField.getText());
                    break;
                case "Vanilla":
                    orderedCake = new VanillaCake();
                    if (sprinkles) orderedCake = new Sprinkles(orderedCake);
                    if (extraLarge) orderedCake = new ExtraLarge(orderedCake);
                    if (addedText) orderedCake = new DecorText(orderedCake, textField.getText());
                    break;
                case "Strawberry":
                    orderedCake = new StrawberryCake();
                    if (sprinkles) orderedCake = new Sprinkles(orderedCake);
                    if (extraLarge) orderedCake = new ExtraLarge(orderedCake);
                    if (addedText) orderedCake = new DecorText(orderedCake, textField.getText());
                    break;
            }
            bakeryViewModel.newCake(orderedCake);
            optionsDialog.dispose();
        });

        /* Create JPanel that centers all components using GridBag layout */
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        /* Create GridBagConstraints for each component to be added */
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weighty = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(10, 0, 10, 0);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weighty = 1;
        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(10, 0, 10, 0);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.weighty = 1;
        c3.gridx = 0;
        c3.gridy = 2;
        c3.insets = new Insets(10, 0, 10, 0);

        /* Add the components to the panel and then add it to the JDialog */
        centerPanel.add(typePanel, c1);
        centerPanel.add(extrasPanel, c2);
        centerPanel.add(placeOrder, c3);

        optionsDialog.add(centerPanel);
        optionsDialog.pack();

        return optionsDialog;
    }
}
