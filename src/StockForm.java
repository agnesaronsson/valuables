/*@author Agnes Aronsson [agar3573]*/
package Valuables;

import javax.swing.*;

public class StockForm extends JPanel {
	private JTextField nameInput = new JTextField(10);;
	private JTextField sharesInput = new JTextField(5);
	private JTextField priceInput = new JTextField(5);
	
	public StockForm() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel firstRow = new JPanel();
		add(firstRow);
		firstRow.add(new JLabel("Name: ", SwingConstants.RIGHT));
		firstRow.add(nameInput);
		
		JPanel secondRow = new JPanel();
		add(secondRow);
		secondRow.add(new JLabel("Shares: ", SwingConstants.RIGHT));
		secondRow.add(sharesInput);
		
		JPanel thirdRow = new JPanel();
		add(thirdRow);
		thirdRow.add(new JLabel("Price: ", SwingConstants.RIGHT));
		thirdRow.add(priceInput);
	}
	
	public String getName() {
		return nameInput.getText();
	}
	
	public int getShares() {
		return Integer.parseInt(sharesInput.getText());
	}
	
	public double getPrice() {
		return Double.parseDouble(priceInput.getText());
	}
}
