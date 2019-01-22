import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class WinstonFlooringOrderApplication extends JFrame implements ActionListener {

		//Create tabbed pane
		private JTabbedPane pane = new JTabbedPane();
		
		//Formats total cost and surface area
		protected DecimalFormat decFormat = new DecimalFormat("$#,##0.00");
		protected DecimalFormat areaFormat = new DecimalFormat("#0.00");
		
		
		//Create content of Flooring Type Tab
		private JLabel lblType = new JLabel("Choose the flooring type: ", JLabel.CENTER);
		protected JRadioButton rdoWood = new JRadioButton("Wood");
		protected JRadioButton rdoCarpet = new JRadioButton("Carpet");
		protected ButtonGroup radioButtons = new ButtonGroup();
		
		
		//Create content for Size Tab
		private JLabel lblSize = new JLabel("Choose the size of your Flooring:", JLabel.CENTER);
		protected JLabel lblLength = new JLabel("Length (feet)", JLabel.CENTER);
		protected JTextField txtLength = new JTextField(10);
		protected JLabel lblWidth = new JLabel("Width (feet)", JLabel.CENTER);
		protected JTextField txtWidth = new JTextField(10);
		protected JButton btnArea = new JButton("Calculate Area");
		private JLabel lblArea = new JLabel("Calculated Area: (Sq. Ft.)");
		protected JTextField txtArea = new JTextField(15);
		private JLabel lblTotal = new JLabel("Calculated Cost: ");
		protected JTextField txtTotal = new JTextField(20);
		protected JButton btnTotal = new JButton("Calculate Cost");
		
		
		//Create content for info Tab
		private JLabel lblInfo = new JLabel("Please enter Customer Information", JLabel.CENTER);
		protected JLabel lblName = new JLabel("Name: ", JLabel.CENTER);
		protected JTextField txtName = new JTextField(50);
		protected JLabel lblAddress = new JLabel("Street Address: ", JLabel.CENTER);
		protected JTextField txtAddress = new JTextField(50);
		protected JButton btnSummary = new JButton("Order Summary");
		protected JButton btnSubmit = new JButton("Submit Order");
		protected JButton btnList = new JButton("Order List");
				
		
		//Creates panels for each tab
		private JPanel p1 = new JPanel();
		private JPanel p2 = new JPanel();
		private JPanel p3 = new JPanel();
		
		//creates custom font
		Font lblFont = new Font("Times New Roman", Font.BOLD, 25);
		
		//Create variables to calculate surface area
		protected double dblLength = 0.0, dblWidth = 0.0, dblArea = 0.0, dblTotal = 0.0;
		protected String strFloor = null;
		
		
		//Creates layouts for tabs
		private GridLayout typeGridLayout = new GridLayout(3, 1, 10, 50);
		private GridLayout sizeGridLayout = new GridLayout(11, 1, 300, 5);
		private GridLayout infoGridLayout = new GridLayout(8, 1, 200, 15);
	
	
	public WinstonFlooringOrderApplication(){
		
		//Sets title of frame
		super("Winston Flooring Order Application");
		
		//Adds radio buttons from Size tab to buttongroup
		radioButtons.add(rdoWood);
		radioButtons.add(rdoCarpet);
		
		
	
		
		//Create box layout manager
		p1.setLayout(typeGridLayout);
		p2.setLayout(sizeGridLayout);
		p3.setLayout(infoGridLayout);
				
		//Adds content to type tab
		p1.add(lblType, BorderLayout.NORTH);
		lblType.setFont(lblFont);
		p1.add(rdoWood, BorderLayout.CENTER);
		rdoWood.setHorizontalAlignment(JRadioButton.CENTER);
		p1.add(rdoCarpet, BorderLayout.SOUTH);
		rdoCarpet.setHorizontalAlignment(JRadioButton.CENTER);
		
		
		p2.add(lblSize);
		lblSize.setFont(lblFont);
		p2.add(lblLength);
		p2.add(txtLength);
		txtLength.setPreferredSize(new Dimension(150, 100));
		txtLength.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lblWidth);
		p2.add(txtWidth);
		txtWidth.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lblArea);
		p2.add(txtArea);
		txtArea.setHorizontalAlignment(SwingConstants.CENTER);
		txtArea.setEditable(false);
		p2.add(btnArea);
		p2.add(lblTotal);
		p2.add(txtTotal);
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setEditable(false);
		p2.add(btnTotal);
		btnArea.addActionListener(this);
		
	
		
		p3.add(lblInfo);
		lblInfo.setFont(lblFont);
		p3.add(lblName);
		p3.add(txtName);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(lblAddress);
		p3.add(txtAddress);
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		btnTotal.addActionListener(this);
		p3.add(btnSummary);
		btnSummary.addActionListener(this);
		p3.add(btnSubmit);
		btnSubmit.addActionListener(this);
		p3.add(btnList);
		btnList.addActionListener(this);
		
		
		pane.addTab("Flooring Type", p1);
		pane.addTab("Flooring Size", p2);
		pane.addTab("Customer Information", p3);
		
		this.add(pane);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//Event handling for calculate area button
		if(e.getSource() == btnArea)
		{
			
			try
			{
				//Calculate and return area
				dblLength = Double.parseDouble(txtLength.getText());
				dblWidth = Double.parseDouble(txtWidth.getText());
				
				//Calculates area and returns value to text field
			dblArea = dblLength * dblWidth;	
			txtArea.setText(areaFormat.format(dblArea));
			}
			catch (NumberFormatException n)
			{
				JOptionPane.showMessageDialog(null, "ERROR: Length and Width must be numerical values.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		}
		
		//Event handling for the calculate cost button
		if(e.getSource() == btnTotal)
		{
		
			//Calculates and returns cost
			if(rdoWood.isSelected() == true)
			{
				dblTotal = dblArea * 20.00;
			}else if(rdoCarpet.isSelected() == true)
			{
				dblTotal = dblArea * 10.00;
			}
			
			txtTotal.setText(decFormat.format(dblTotal));
			
			if(rdoWood.isSelected() == false && rdoCarpet.isSelected() == false)
			{
				JOptionPane.showMessageDialog(null, "ERROR: Flooring type must be selected before calculations.", "ERROR", JOptionPane.ERROR_MESSAGE);
				txtTotal.setText(null);
			}		
			
		}
		
		//Determines floor string value
			if(rdoWood.isSelected() == true)
			{
				strFloor = rdoWood.getText();
			}else if(rdoCarpet.isSelected() == true)
			{
				strFloor = rdoCarpet.getText();
			}
		
		//Event handling for order summary button
		if(e.getSource() == btnSummary)
		{
			//Prints out order summary before submission
			FlooringOrderSummary fos = new FlooringOrderSummary(txtName.getText(), txtAddress.getText(), strFloor, 
																dblArea, dblTotal);
			fos.setVisible(true);
			
		}
		
		//Event handling for order list button
		if(e.getSource() == btnList)
		{
			//Outputs database to new window in a text area
			FlooringDatabaseDisplay fdd = new FlooringDatabaseDisplay();
			fdd.setVisible(true);
			
			
		}
			
		
		//Event handling for submit order button
		if(e.getSource() == btnSubmit)
		{
	
			//Data validation for program
			if(rdoWood.isSelected() == false && rdoCarpet.isSelected() == false)
			{
				JOptionPane.showMessageDialog(null, "ERROR: Flooring type not selected. Please select the flooring type in the type tab.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(txtLength.getText().isEmpty() || txtWidth.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "ERROR: Area and Cost not properly calculated. Please enter the appropriate numbers for surface area.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(txtName.getText().isEmpty() || txtAddress.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "ERROR: Customer information invalid. Please ensure that all customer info has been entered.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		
			
			else
			{
				//If no errors, proceed with submission
				Connection conn = null;
				//1. Make connection to database
				try {
					conn = DriverManager
							.getConnection("jdbc:mysql://devry.edupe.net:4300/CIS355_4425", "4425", "Metallica123");
					
					//2. Prepared statement/query
					String insertQuery = "insert into flooring (CustomerName, CustomerAddress, FlooringType, FloorArea, FloorCost)"
							+ "values (?, ?, ?, ?, ?)";
					
					PreparedStatement myquery = conn.prepareStatement(insertQuery);
					
					//4. get string until EOF
						//Gets each individual row
						myquery.setString(1, txtName.getText());
						myquery.setString(2, txtAddress.getText());
						myquery.setString(3, strFloor);
						myquery.setDouble(4, dblArea);
						myquery.setDouble(5, dblTotal);
						
						
						//Executes query
						myquery.execute();
						JOptionPane.showMessageDialog(null, "Your order has been submitted. Thank you for your service!");
						
						
						//Clears all GUI data for next user input
						txtName.setText(null);
						txtAddress.setText(null);
						rdoWood.setSelected(false);
						rdoCarpet.setSelected(false);
						txtLength.setText(null);
						txtWidth.setText(null);
						txtArea.setText(null);
						
						
				} catch (SQLException s) {
					
					s.printStackTrace();
					JOptionPane.showMessageDialog(null, "Connection to the database failed! Please contact us for assistance.");
					
				}
				finally
				{
					try
					{
						//if connection is not null, close connection
						if(conn != null)
						{
							conn.close();
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
					}
				}	
			}	
		}
		
		
		
	}

}
