import javax.swing.*;

@SuppressWarnings("serial")
public class FlooringDatabaseDisplay extends WinstonFlooringOrderApplication {

	//Create text area for summary
		protected JTextArea txtSummary = new JTextArea();
		
		public FlooringDatabaseDisplay(){
			
			//Sets title of frame
			super();
			
			//sets size and title of frame
			this.setSize(850, 300);
			this.setTitle("Database Display");
			
			//adds text area to frame
			add(txtSummary);
			txtSummary.setEditable(false);
		}
}
			
			
			
			//adds content to text area
			//Connection conn = null;
			//Makes connection to database
			//try {
				//No Longer works!
				//conn = DriverManager.getConnection("", "4425", "Metallica123");
				
				//Create statement to display
				//java.sql.PreparedStatement myQuery = conn.prepareStatement("Select * from flooring");
				
				//Execute Query
				//ResultSet result = myQuery.executeQuery();
				
				
				//Display database
				/*while(result.next())
				{
					txtSummary.append("\n     " + result.getString(1) + "                  "
									+ result.getString(2) + "                      "
									+ result.getString(3) + "                      "
									+ result.getString(4) + "                      "
									+ result.getString(5) + "                      "
									+ "$" + result.getString(6));
				}
				
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Connection to the database failed! Please contact us for assistance.");
			}
			finally
			{
				try
				{
					if(conn != null)
					{
						//Closes database connection if exists
						conn.close();
					}
				}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}*/
			
		
