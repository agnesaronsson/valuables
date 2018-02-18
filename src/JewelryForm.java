/*@author Agnes Aronsson [agar3573]*/
package Valuables;

import javax.swing.*;

public class JewelryForm extends JPanel {
	private JTextField nameInput = new JTextField(10);;
	private JTextField gemsInput = new JTextField(5);
	private JCheckBox elementInput = new JCheckBox("Of gold");
	
	public JewelryForm() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel firstRow = new JPanel();
		add(firstRow);
		firstRow.add(new JLabel("Name: ", SwingConstants.RIGHT));
		firstRow.add(nameInput);
		
		JPanel secondRow = new JPanel();
		add(secondRow);
		secondRow.add(new JLabel("Gems: ", SwingConstants.RIGHT));
		secondRow.add(gemsInput);
		
		JPanel thirdRow = new JPanel();
		add(thirdRow);
		thirdRow.add(elementInput);
	}
	
	public String getName() {
		return nameInput.getText();
	}
	
	public int getGems() {
		return Integer.parseInt(gemsInput.getText());
	}
	
	public boolean getElement() {
		if(elementInput.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
}
