package Module1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton save = new JButton();
	JButton load = new JButton();
	JTextArea textArea = new JTextArea(50, 50);
	FileWriter fw;
	BufferedReader br;
	
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
		save.addActionListener(this);
		load.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==save) {
			try {
				fw = new FileWriter("src/Module1/editableText.txt");
				fw.write(textArea.getText());
				fw.close();
			}
			catch(IOException e1) {
				e1.printStackTrace();
			}
			
		}
		else {
			try {
				
				br = new BufferedReader(new FileReader("src/Module1/editableText.txt"));
				String txtText = " ";
				
				while(txtText!=null) {
					txtText += br.readLine() + "\n";
				}
				textArea.setText(txtText);
			}
			catch(IOException e1) {
				System.out.println("Oh friggin heck");
				e1.printStackTrace();
			}
			
		}
	}
}
