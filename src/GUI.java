import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUI implements ActionListener {
	JFrame frame;
	
	static JPanel panel, panel1;
	static JLabel label, label1;
	static JButton startButton, continueButton, oneButton, twoButton, threeButton;
	static int x = 0;
	
	public GUI()
	{
		frame = new JFrame();
		
		//Start of starting screen
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(4, 1));
		
		
		startButton = new JButton("Start Game");
		startButton.addActionListener(this);
		
		label = new JLabel("The Dungeon");
		label.setBounds(50, 50, 50, 50);
	    label.setFont(new Font("Arial", Font.PLAIN, 30));
		
		panel.add(label);
		panel.add(startButton);
		//End of starting screen
		
		//Start of main screen
		panel1 = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(5, 5));
		
		oneButton = new JButton("1");
		twoButton = new JButton("2");
		threeButton = new JButton("3");
		continueButton = new JButton("Continue");
		
		label1 = new JLabel(mainText());
		
		oneButtonListener listenerOne = new oneButtonListener();
		oneButton.addActionListener(listenerOne);
		
		panel1.add(label1);
		panel1.add(continueButton);
		panel1.add(oneButton);
		panel1.add(twoButton);
		panel1.add(threeButton);
		
		//End of main screen
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("The Dungeon");
		frame.pack();
		frame.setVisible(true);
;	}
	
	private String mainText() {
		
		String[] text = {"",
				"Select your character: [1]Mage [2]Hunter [3]Warrior", 
				"Welcome hero. The King has reaches out in need of your help. Your mission is to go and save them from the dungeon.",
				
						};
		
		
		
		String y = text[x];
		x++;
		
		return y;
	}

	public static void main(String[] args)
	{
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		panel.setVisible(false);
		frame.add(panel1);
		
	}
	
	
	
	private class oneButtonListener implements ActionListener {

		

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			label1.setText(mainText());
			
		}

	}

}

