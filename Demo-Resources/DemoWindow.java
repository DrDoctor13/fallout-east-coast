import java.awt.BorderLayout;

import javax.swing.*;


public class DemoWindow {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("Fallout: East Coast");
		jf.setSize(600, 700);
		
		final JTextField CommandField = new JTextField();
		jf.getContentPane().add(CommandField, BorderLayout.PAGE_END);
		
		final JTextArea LogField = new JTextArea("Please enter your name." + "\nAh, hello there, Buck. Are you a boy or a girl?");
		jf.getContentPane().add(LogField, BorderLayout.CENTER);
		LogField.setEditable(false);
		
				
		
		jf.setVisible(true);

	}

}
