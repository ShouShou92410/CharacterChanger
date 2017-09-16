package CharacterChanger;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

public class CCView extends JFrame
{
	private static GridBagConstraints gbc = new GridBagConstraints();
	private JButton load_button, store_button;
	private JTextField input_file_path, output_file_path;
	//private JTextArea input_data, output_data;
	//private JScrollPane input_data_scroll, output_data_scroll;
	private JLabel input_file_path_label, input_data_label, output_file_path_label, output_data_label;
	private JPanel input_panel, output_panel;
	
	public CCView()
	{
		super("Character Replacer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		setResizable(false);
		setSize(1200,200);
		
		gbc.ipady = 20;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		//Input side
		input_panel = new JPanel(new GridBagLayout());
		input_file_path_label = new JLabel("Input file path: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		input_panel.add(input_file_path_label, gbc);
		
		input_file_path = new JTextField(50);
		gbc.gridx = 0;
		gbc.gridy = 1;
		input_panel.add(input_file_path, gbc);
		
		load_button = new JButton("Load");
		//load_button.set
		gbc.gridx = 0;
		gbc.gridy = 2;
		input_panel.add(load_button, gbc);
		/*
		input_data_label = new JLabel("Input data: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		input_panel.add(input_data_label, gbc);
		
		input_data = new JTextArea(40, 50);
		input_data_scroll = new JScrollPane (input_data);
		gbc.gridx = 0;
		gbc.gridy = 4;
		input_panel.add(input_data_scroll, gbc);
		*/
		//Output side
		output_panel = new JPanel(new GridBagLayout());
		output_file_path_label = new JLabel("Output file path: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		output_panel.add(output_file_path_label, gbc);
		
		output_file_path = new JTextField(50);
		gbc.gridx = 0;
		gbc.gridy = 1;
		output_panel.add(output_file_path, gbc);
		
		store_button = new JButton("Store");
		gbc.gridx = 0;
		gbc.gridy = 2;
		output_panel.add(store_button, gbc);
		/*
		output_data_label = new JLabel("Output data: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		output_panel.add(output_data_label, gbc);
		
		output_data = new JTextArea(40, 50);
		output_data.setEditable(false);
		output_data_scroll = new JScrollPane (output_data);
		gbc.gridx = 0;
		gbc.gridy = 4;
		output_panel.add(output_data_scroll, gbc);
		*/
		//Add to the frame
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(input_panel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(output_panel, gbc);
	}
	
	public void set_input_file_path(String temp)
	{
		input_file_path.setText(temp);
	}
	
	public String get_input_file_path()
	{
		return input_file_path.getText();
	}
	
	public void set_output_file_path(String temp)
	{
		output_file_path.setText(temp);
	}
	
	public String get_output_file_path()
	{
		return output_file_path.getText();
	}
	/*
	public void set_input_data(String temp)
	{
		input_data.setText(temp);
	}
	
	public String get_input_data()
	{
		return input_data.getText();
	}
	
	public void set_output_data(String temp)
	{
		output_data.setText(temp);
	}
	
	public String get_output_data()
	{
		return output_data.getText();
	}
	
	public void addInputDocListener(DocumentListener DocumentListener)
	{
		input_data.getDocument().addDocumentListener(DocumentListener);
	}
	*/
	public void addLoadListener(ActionListener buttonListener)
	{
		load_button.addActionListener(buttonListener);
	}
	
	public void addStoreListener(ActionListener buttonListener)
	{
		store_button.addActionListener(buttonListener);
	}
	
	public void displayError(String error)
	{
		JOptionPane.showMessageDialog(this, error);
	}
}
