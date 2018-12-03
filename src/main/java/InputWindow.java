

import com.mongodb.client.DistinctIterable;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/*
 * Class for initializing the GUI and detecting user inputs.
 */
public class InputWindow extends JFrame {

    /*private JTextField name;
    private JTextField manufacturer;
    private JTextField price;
    private JTextField amount;
    private JTextField searchField;*/

    private JComboBox warsSelect;
    private JTextField urlField;
    private JButton addButton;
    private JButton editButton;
    private JButton searchButton;
    private JTable table;

    private DBHandler dbHandler;

    public InputWindow(DBHandler dbHandler) {

        super("Battlemap Applet");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.dbHandler = dbHandler;
        List<String> wars = new ArrayList<String>();
        dbHandler.collection.distinct("war", String.class).into(wars);



        warsSelect = new JComboBox(wars.toArray());

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(warsSelect, gbc);}

        /*undoButton = new JButton("Undo");
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.insets= new Insets(0, 0, 2, 70);
        gbc.fill=GridBagConstraints.NONE;
        add(undoButton, gbc);
        undoButton.setEnabled(false);

        redoButton = new JButton("Redo");
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.insets= new Insets(0, 60, 2, 2);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(redoButton, gbc);
        redoButton.setEnabled(false);

        InventoryTableModel model = new InventoryTableModel();
        table = new JTable(model);

        //Make sure all the cell text is right aligned.
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=3;
        gbc.insets= new Insets(0, 0, 0, 0);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        JScrollPane pane = new JScrollPane(table);
        pane.getViewport().setBackground(Color.WHITE);
        add(pane, gbc);

        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.insets= new Insets(0,100,0,0);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(nameLabel, gbc);

        //Text fields for adding new rows.
        name = new JTextField(20);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=2;
        gbc.insets= new Insets(2,20,0,0);
        gbc.ipady=5;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(name, gbc);

        JLabel manufacturerLabel = new JLabel("Manufacturer:");
        manufacturerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.insets= new Insets(0,100,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(manufacturerLabel, gbc);

        manufacturer = new JTextField(20);
        manufacturer.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=2;
        gbc.insets= new Insets(2,20,0,0);
        gbc.ipady=5;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(manufacturer, gbc);

        JLabel priceLabel = new JLabel("Product Price:");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.insets= new Insets(0,100,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(priceLabel, gbc);

        price = new JTextField(20);
        price.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.gridwidth=2;
        gbc.insets= new Insets(2,20,0,0);
        gbc.ipady = 5;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(price, gbc);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.insets= new Insets(0,100,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(amountLabel, gbc);

        amount = new JTextField(20);
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx=1;
        gbc.gridy=6;
        gbc.gridwidth=2;
        gbc.insets= new Insets(2,20,0,0);
        gbc.ipady = 5;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(amount, gbc);

        inputButton = new JButton("Add To Inventory");
        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=2;
        gbc.insets= new Insets(5,20,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(inputButton, gbc);

        deleteButton = new JButton("Remove Selected Row");
        gbc.gridx=1;
        gbc.gridy=8;
        gbc.gridwidth=2;
        gbc.insets= new Insets(5,20,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(deleteButton, gbc);

        // Text Field and Button for the search function
        searchField = new JTextField(20);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx=1;
        gbc.gridy=9;
        gbc.gridwidth=1;
        gbc.insets= new Insets(5,20,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.BOTH;
        add(searchField, gbc);

        searchButton = new JButton("Search By Name");
        gbc.gridx=2;
        gbc.gridy=9;
        gbc.gridwidth=1;
        gbc.insets= new Insets(5,5,0,0);
        gbc.ipady = 0;
        gbc.fill=GridBagConstraints.BOTH;
        add(searchButton, gbc);

        // Set up all the EventListeners for the buttons, ComboBox, and searchField.
        EventHandler h = new EventHandler();
        ActionListener undoAction = new UndoAction();
        ActionListener redoAction = new RedoAction();

        inputButton.addActionListener(h);
        deleteButton.addActionListener(h);
        typePicker.addActionListener(h);
        searchField.addActionListener(h);
        searchButton.addActionListener(h);

    }

    /*
     * Inner class to handle all the button clicks and user inputs,
     * except for direct cell input; The InventoryTableModel class handles this within itself.
     */

}
