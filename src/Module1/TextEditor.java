package Module1;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton save = new JButton();
	JButton load = new JButton();
	JTextArea textArea = new JTextArea(50, 50);
	
	TextEditor(){
		frame.add(panel);
		panel.add(textArea);
		panel.add(save);
		panel.add(load);
		
		frame.setVisible(true);
		panel.setPreferredSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		save.setText("Save");
		load.setText("Load");
		
		frame.pack();
	}
}
