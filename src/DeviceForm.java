/*@author Agnes Aronsson [agar3573]*/
package Valuables;

import javax.swing.*;

public class DeviceForm extends JPanel {
	private JTextField nameInput = new JTextField(10);;
	private JTextField priceInput = new JTextField(5);
	private JTextField wearInput = new JTextField(5);
	
	public DeviceForm() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel firstRow = new JPanel();
		add(firstRow);
		firstRow.add(new JLabel("Name: ", SwingConstants.RIGHT));
		firstRow.add(nameInput);
		
		JPanel secondRow = new JPanel();
		add(secondRow);
		secondRow.add(new JLabel("Price: ", SwingConstants.RIGHT));
		secondRow.add(priceInput);
		
		JPanel thirdRow = new JPanel();
		add(thirdRow);
		thirdRow.add(new JLabel("Wear: ", SwingConstants.RIGHT));
		thirdRow.add(wearInput);
	}
	
	public String getName() {
		return nameInput.getText();
	}
	
	public double getPrice() {
		return Double.parseDouble(priceInput.getText());
	}
	
	public int getWear() {
		return Integer.parseInt(wearInput.getText());
	}
}
