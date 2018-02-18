/*@author Agnes Aronsson [agar3573]*/
import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemIndex extends JFrame {
	private ArrayList<Valuable> allValuables = new ArrayList<>();
	private JTextArea output;
	private JComboBox<String> dropdown;
	private JButton display, crash;
	private JRadioButton nameSort, valueSort;
	
	public ItemIndex() {
		super("Item index");
		
		JLabel addNew = new JLabel("New: ");
		
		String[] dropdownItems = {"Jewelry", "Stock", "Device"};
		dropdown = new JComboBox<>(dropdownItems);
		add(dropdown);
		dropdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				dropdownSelection();
			}
		});
		
		display = new JButton("Display");
		add(display);
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				displayItems();
			}
		});
		
		crash = new JButton("Stock market crash");
		add(crash);
		crash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				resetStockShares();
			}
		});
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		southPanel.add(addNew);
		southPanel.add(dropdown);
		southPanel.add(display);
		southPanel.add(crash);
		
		JLabel title = new JLabel("Valuables", JLabel.CENTER);
		add(title, BorderLayout.NORTH);
		
		JPanel eastPanel = new JPanel();
		add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		eastPanel.add(new JLabel("Sorting "));
		nameSort = new JRadioButton("Name", true);
		eastPanel.add(nameSort);
		valueSort = new JRadioButton("Value");	
		eastPanel.add(valueSort);
		ButtonGroup options = new ButtonGroup();
		options.add(nameSort);
		options.add(valueSort);
		
		output = new JTextArea();
		output.setEditable(false);
		JScrollPane window = new JScrollPane(output);
		add(window, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE); //do_nothing_on_close, default är minimera
		setSize(430,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void dropdownSelection() {
		int selectedIndex = dropdown.getSelectedIndex();
		
		if(selectedIndex == 0) {
			addNewJewelry();
		} else if(selectedIndex == 1) {
			addNewStock();
		} else if (selectedIndex == 2){
			addNewDevice();
		}
	}
	
	public boolean validateName(String name) {
		if(name == null || name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Name field can not be empty!", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
	
	public String formatName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
	
	public void addNewJewelry() {
		JewelryForm addJewelry = new JewelryForm();
		
		try {
			int i = JOptionPane.showConfirmDialog(null, addJewelry, "New jewelry", 
					JOptionPane.OK_CANCEL_OPTION);
			if(i != JOptionPane.OK_OPTION) {
				return;
			}
			String name = addJewelry.getName();
			int gems = addJewelry.getGems();
			boolean element = addJewelry.getElement();
			
			if(validateName(name)) {
				Jewelry newJewelry = new Jewelry(formatName(name), gems, element);			
				allValuables.add(newJewelry);
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input!\n'Gems' value should be a number.", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void addNewStock() {
		StockForm addStock = new StockForm();
		
		try {
			int i = JOptionPane.showConfirmDialog(null, addStock, "New stock", 
					JOptionPane.OK_CANCEL_OPTION);
			if(i != JOptionPane.OK_OPTION) {
				return;
			}
			String name = addStock.getName();
			int shares = addStock.getShares();
			double price = addStock.getPrice();
			
			if(validateName(name)) {
				Stock newStock = new Stock(formatName(name), shares, price);			
				allValuables.add(newStock);
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input!\n'Shares' and 'Price' values should be numbers.", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void addNewDevice() {
		DeviceForm addDevice = new DeviceForm();
		
		try {
			int i = JOptionPane.showConfirmDialog(null, addDevice, "New device", 
					JOptionPane.OK_CANCEL_OPTION);
			if(i != JOptionPane.OK_OPTION) {
				return;
			}
			String name = addDevice.getName();
			double price = addDevice.getPrice();
			int wear = addDevice.getWear();
			
			if(validateName(name)) {
				if(wear > 10) {
					JOptionPane.showMessageDialog(null, "Please enter wear as a number between 1-10.\n10 is brand new and 1 is worn out.", "ERROR", 
							JOptionPane.ERROR_MESSAGE);
				} else {
					Device newDevice = new Device(formatName(name), price, wear);			
					allValuables.add(newDevice);
				}
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input!\n'Price' and 'Wear' values should be numbers.", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void displayItems() {
		output.setText(null);
		
		if(nameSort.isSelected()) {
			Collections.sort(allValuables, new NameComparator());
		} else if(valueSort.isSelected()) {
			Collections.sort(allValuables, new ValueComparator());
		}
		
		for(Valuable valuable : allValuables) {
			output.append(valuable.toString() + "\n");
		}
	}
	
	public void resetStockShares() {
		for(Valuable valuable : allValuables) {
			if(valuable instanceof Stock) {
				Stock stock = (Stock)valuable;
				stock.setPrice(0);
			}
		}
	}
}
