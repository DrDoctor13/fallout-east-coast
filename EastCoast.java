//Significant code contribution by Kolby Dukes

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

//Class to hold the data to be output to the Text Area
class ConsoleData {
	ArrayList<String> consoleOutput = new ArrayList<String>();
	
	//Will add a string to the array for the TextArea
	void addStringToConsole(String s) {
		consoleOutput.add(s);
	}
	
	//Return the text from the array in a format that will display properly in the TextArea
	String returnConsoleOutputForTextArea() {
		//Create a new string that will hold our text to be set to the JTextArea
		String outputText = "";
		//Using a for loop that for each String in the array, it adds to the end of our output String the next line with a line break
		for (String s : consoleOutput) {
			outputText = outputText + s + "\n";
			}
				
		return outputText;
	}
	
}



public class EastCoast {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("Fallout: East Coast");
		jf.setSize(600, 700);
		
		final JTextField CommandField = new JTextField();
		jf.getContentPane().add(CommandField, BorderLayout.PAGE_END);
		
		//Create a ConsoleData instance to hold the data for the text area
		final ConsoleData cd = new ConsoleData();
		cd.addStringToConsole("Please enter your name!");
		

		final JTextArea LogField = new JTextArea();
		
		//Create a class to listen for the "enter" on the text field
		class TextFieldActionListener implements ActionListener {
			//This method will get called whenever the text field gets an "enter" key
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//read the text from the command field
				String response = CommandField.getText();
				
				//if/then/else statement to take action based on the given input
				 if (response.equals("Jump out the window")) {
					//add some response to the console data (cd)
					 cd.addStringToConsole("Oh no, you died.");
				 }
				
				//Update the log field with the new data
				LogField.setText(cd.returnConsoleOutputForTextArea());
				
				//Just for debugging
				System.out.println("Enter was pressed.");
				
			}
			
		}
		
		CommandField.addActionListener(new TextFieldActionListener());
		
		
		
		
		LogField.setText(cd.returnConsoleOutputForTextArea());
		jf.getContentPane().add(LogField, BorderLayout.CENTER);
		LogField.setEditable(false);
		
				
		
		jf.setVisible(true);

	}

}
