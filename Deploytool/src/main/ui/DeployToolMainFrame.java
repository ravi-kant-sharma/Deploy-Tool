package main.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DeployToolMainFrame extends JFrame{
	
	public DeployToolMainFrame(){
		super("Build Tool");
		init();
	}
	
	private void init(){
		setLayout(null);
		Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int i = 905;
		int j = 605;
		setBounds((int)localDimension.getWidth(), (int)localDimension.getHeight(), i, j);
	}
	
	public static void main(String[] args){
		
	}

}
