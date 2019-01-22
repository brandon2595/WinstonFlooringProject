import javax.swing.*;

@SuppressWarnings("serial")
public class FlooringOrderSummary extends WinstonFlooringOrderApplication {

	//Create text area for summary
	protected JTextArea txtSummary = new JTextArea();
	
	public FlooringOrderSummary(String strName, String strAddress, String strType, 
								Double dblArea, Double dblTotal){
		
		//Sets title of frame
		super();
		
		
		//sets size and title of frame
		this.setSize(450, 125);
		this.setTitle("Order Summary");
		
		//adds text area to frame
		add(txtSummary);
		txtSummary.setEditable(false);
		
		//Adds content to text area
		txtSummary.append("Customer Name: " + strName + "\n"
						+ "Customer Address: " + strAddress + "\n"
						+ "Flooring Type: " + strType + "\n"
						+ "Surface Area: " + areaFormat.format(dblArea) + " Sq ft" + "\n"
						+ "Grand Total: " + decFormat.format(dblTotal));
		
		
	}
}
