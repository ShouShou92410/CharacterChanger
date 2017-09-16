package CharacterChanger;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CCController 
{
	private CCView view;
	private CCModel model;
	private FileDialog fdlg;
	//private String input_data = "", output_data = "";
	
	public CCController(CCView view, CCModel model)
	{
		this.view = view;
		this.model = model;
		this.view.addStoreListener(new store_listener());
		this.view.addLoadListener(new load_listener());
		//this.view.addInputDocListener(new input_data_listener());
	}
	/*
	class input_data_listener implements DocumentListener
	{
		public void changedUpdate(DocumentEvent arg0) 
		{
			view.set_output_data(view.get_input_data());
		}

		public void insertUpdate(DocumentEvent arg0) 
		{
			view.set_output_data(view.get_input_data());
		}

		public void removeUpdate(DocumentEvent arg0) 
		{
			view.set_output_data(view.get_input_data());
		}
	}
	*/
	class store_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try
			{
				if (fdlg.getFile() != null)
				{
					BufferedWriter bfw = new BufferedWriter(new FileWriter(view.get_output_file_path()));
					BufferedReader bfr = new BufferedReader(new FileReader(view.get_input_file_path()));
					String temp = bfr.readLine();
					while(temp != null)
					{
						temp = model.newString(temp);
						bfw.write(temp);
						temp = bfr.readLine();
						if (temp != null)
							bfw.newLine();
					}
					bfr.close();
					bfw.flush();
					bfw.close();
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				view.displayError("Oops, something went wrong");
			}
		}
	}
	
	class load_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			fdlg = new FileDialog(view, "Load", 0);
			fdlg.setVisible(true);
			String file_path = fdlg.getDirectory() + fdlg.getFile();
			
			try
			{
				if (fdlg.getFile() != null)
				{
					view.set_input_file_path(file_path);
					view.set_output_file_path(file_path.substring(0, (file_path.lastIndexOf("\\")+1)) + "Output.txt");
					/*
					BufferedReader bfr = new BufferedReader(new FileReader(file_path));
					String temp;
					while((temp = bfr.readLine()) != null)
					{
						input_data = input_data + temp + "\n";
					}
					bfr.close();
					
					view.set_input_data(input_data.substring(0, input_data.length()-1));		//Substring to remove the \n at the end
					*/
				}
			}
			catch(Exception ex)
			{
				
				view.displayError("Oops, something went wrong");
			}
		}
	}
}
