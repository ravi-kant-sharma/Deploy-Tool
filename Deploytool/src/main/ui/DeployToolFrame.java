package main.ui;
/*
 * DeployToolJFrame.java
 *
 * Created on __DATE__, __TIME__
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import main.util.DeployUtil;

/**
 *
 * @author  __USER__
 */
public class DeployToolFrame extends javax.swing.JFrame {

	/** Creates new form DeployToolJFrame */
	public DeployToolFrame() {
		
		initComponents();
	}

	final String skipDatabase = "-DskipDatabase";
	final String skipTests = "-DskipTests";
	final String u = "-U";
	final String o = "-o";
	public String deployToolHome;
	public File jbosspath;
	public Properties config_path = new Properties(); 
	
	

	public String getDeployToolHome() {
		return deployToolHome;
	}

	public void setDeployToolHome(String deployToolHome) {
		this.deployToolHome = deployToolHome;
	}

	DeployUtil deployUtil = new DeployUtil();

	//	Properties prop = new Properties();

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		projectListComboBox = new javax.swing.JComboBox();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jLabel2 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jPanel3 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		skipDatabaseCheckBox = new javax.swing.JCheckBox();
		skipTestsCheckBox = new javax.swing.JCheckBox();
		jPanel5 = new javax.swing.JPanel();
		clearTempCheckBox = new javax.swing.JCheckBox();
		jLabel5 = new javax.swing.JLabel();
		buildBtn = new javax.swing.JButton();
		buildAndCopyBtn = new javax.swing.JButton();
		copyBtn = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		startJBossBtn = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		EditPreferencesBtn = new javax.swing.JMenuItem();
		editWorkbench = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(0, 0, 800, 600));
		
		File deployToolHomeFileC = new File("C:\\DeployTool");
		File deployToolHomeFileD = new File("D:\\DeployTool");
		File deployToolHomeFileE = new File("E:\\DeployTool");
		
		if(deployToolHomeFileC.exists()){
			setDeployToolHome("C:\\DeployTool");
		}else if(deployToolHomeFileD.exists()){
			setDeployToolHome("D:\\DeployTool");
		}else if(deployToolHomeFileE.exists()){
			setDeployToolHome("E:\\DeployTool");
		}else{
			setDeployToolHome(System.getenv("DEPLOY_HOME"));
		}

		jLabel1.setText("Select Project");
		Object[] list = null;
		try {
			list = deployUtil.getPropertiesList(deployToolHome+"\\config.properties");
			config_path.load(new FileInputStream(new File(deployToolHome+"\\config_path.properties")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	
		
		projectListComboBox.setModel(new javax.swing.DefaultComboBoxModel(list));
		String path = (String) deployUtil.getProp().get(
				projectListComboBox.getItemAt(0));
		File f = new File(path);
		ArrayList<String> aList = new ArrayList<String>();
		if (f.exists()) {
			File[] fileList = f.listFiles();
			for (File file : fileList) {
				if (file.isDirectory() && !file.getName().equalsIgnoreCase("lost+found")) {
					aList.add(file.getName());
				}
			}
		}
		jList1.setListData(aList.toArray());
		projectListComboBox.setMinimumSize(new java.awt.Dimension(100, 20));
		projectListComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});
		
		projectListComboBox.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
				jComboBox1FocusGained(evt);
			}
		} );
		
		jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(
				0, 0, 0), 1, true));

//		jList1.setModel(new javax.swing.AbstractListModel() {
//			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4",
//					"Item 5" };
//
//			public int getSize() {
//				return strings.length;
//			}
//
//			public Object getElementAt(int i) {
//				return strings[i];
//			}
//		});
		jScrollPane1.setViewportView(jList1);

		jLabel2.setText("Available Projects");

		jCheckBox1.setText("Select All | None");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				267,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				54,
																				Short.MAX_VALUE)
																		.addComponent(
																				jCheckBox1)
																		.addGap(21,
																				21,
																				21)))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(13, 13, 13)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jCheckBox1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												329, Short.MAX_VALUE)
										.addContainerGap()));

		jPanel2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel3.setText("Projects Selected");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																345,
																Short.MAX_VALUE)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																312,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												16,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												175, Short.MAX_VALUE)
										.addContainerGap()));

		jPanel3.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel4.setText("Build Options");

		jPanel4.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("o");

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("U");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		skipDatabaseCheckBox.setSelected(true);
		skipDatabaseCheckBox.setText("skipDatabase");
		skipDatabaseCheckBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}
		});

		skipTestsCheckBox.setSelected(true);
		skipTestsCheckBox.setText("skipTests");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																skipTestsCheckBox)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jRadioButton1)
																		.addGap(36,
																				36,
																				36)
																		.addComponent(
																				jRadioButton2))
														.addComponent(
																skipDatabaseCheckBox))
										.addContainerGap(54, Short.MAX_VALUE)));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(17, 17, 17)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jRadioButton1)
														.addComponent(
																jRadioButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(skipDatabaseCheckBox)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(skipTestsCheckBox)
										.addContainerGap(51, Short.MAX_VALUE)));

		jPanel5.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		clearTempCheckBox.setText("Clear Temp files");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addContainerGap()
						.addComponent(clearTempCheckBox)
						.addContainerGap(41, Short.MAX_VALUE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addContainerGap()
						.addComponent(clearTempCheckBox)
						.addContainerGap(109, Short.MAX_VALUE)));

		jLabel5.setText("Jboss Options");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel5)
														.addComponent(
																jPanel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel4,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));

		buildBtn.setText("Build");
		buildBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					buildBtnActionPerformed(evt);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		buildAndCopyBtn.setText("Build & Copy");

		copyBtn.setText("Copy");

		jButton4.setText("Copy All");

		startJBossBtn.setText("Start JBoss");

		jMenu1.setText("Preferences");

		EditPreferencesBtn.setText("Edit Preferences");
		EditPreferencesBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						EditPreferencesBtnActionPerformed(evt);
					}
				});
		jMenu1.add(EditPreferencesBtn);

		editWorkbench.setText("Edit Workbench Path");
		editWorkbench.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(editWorkbench);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanel1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										projectListComboBox,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										217,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanel3,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jPanel2,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		buildBtn)
																.addGap(18, 18,
																		18)
																.addComponent(
																		buildAndCopyBtn)
																.addGap(18, 18,
																		18)
																.addComponent(
																		copyBtn)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton4)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		150,
																		Short.MAX_VALUE)
																.addComponent(
																		startJBossBtn)
																.addGap(129,
																		129,
																		129)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jPanel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jPanel3,
																		0,
																		186,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						projectListComboBox,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										37, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(buildBtn)
												.addComponent(buildAndCopyBtn)
												.addComponent(copyBtn)
												.addComponent(jButton4)
												.addComponent(startJBossBtn))
								.addGap(24, 24, 24)));
		buildAndCopyBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buildAndCopyBtnActionPerformed(evt);
			}
		});
		
		copyBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				copyBtnActionPerformed(evt);
			}
		});
		
		startJBossBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startJBossBtnActionPerformed(evt);
			}
		});

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		EditWorkbenchDialog workbench = new EditWorkbenchDialog(this,true);
		workbench.setSize(600,250);
		workbench.setVisible(true);
	}
	
	public void startJBossBtnActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Process p = Runtime.getRuntime().exec("cmd /c netstat -ano | find \"8787\" > "+deployToolHome+"\\jboss_status.txt");	
			try {
				Thread.sleep(1000);
				File f1 = new File(deployToolHome+"\\jboss_status.txt"); 
				FileInputStream fis = new FileInputStream(f1);
				byte[] b = new byte[(int)f1.length()];
				fis.read(b);
				fis.close();
				String output =  new String(b);
				if(output != null && output.length() > 0){
					InfoDialog dialog = new InfoDialog(this,"INFO","Jboss is already running");
					dialog.setSize(300, 100);
					dialog.show(true);
				}else{
					if(clearTempCheckBox != null && clearTempCheckBox.isSelected()){
						String path = (String) config_path.get("WORKBENCH_PATH");
						int index = path.indexOf("iipdev");
						path = path.substring(0, index+6);
						String[] strs ={"log","tmp","work"};
						for(String dir : strs){
							String dirPath = path+"\\"+dir;
							File f = new File(dirPath);
							if(f.exists()){
								File tempDelFile  = new File(deployToolHome+"\\temp_del.bat");
								if(tempDelFile.exists()){
									StringBuilder command = new StringBuilder();
									FileOutputStream tempDelFos = new FileOutputStream(tempDelFile);
									command.append("cmd /c rmdir /S /Q "+dirPath);
									command.append("\r\n");
									command.append("exit");
									byte[] b1 = new byte[command.length()];
									b1 = command.toString().getBytes();
									tempDelFos.write(b1);
									tempDelFos.close();
								}
								Runtime.getRuntime().exec("cmd /c start "+deployToolHome+"\\temp_del.bat");
							}
						}
					}
					Runtime.getRuntime().exec("cmd /c start "+deployToolHome+"\\jboss_start.bat");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean buildAndCopyFlag;
	private String projectBuilding;
	Object[] selectedVals=null;
	private void buildAndCopyBtnActionPerformed(ActionEvent evt) {
		try {
			buildAndCopyFlag = true;
			buildBtnActionPerformed(evt);
			copyBtnActionPerformed(evt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void copyBtnActionPerformed(ActionEvent evt) {
		String path;
		Object[] selectedValues;
		if(buildAndCopyFlag){
			path = projectBuilding;
			selectedValues = selectedVals;
		}else{
			path = (String) deployUtil.getProp().get(
				projectListComboBox.getSelectedItem());
			selectedValues = (Object[]) jList1.getSelectedValues();
		}
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File(deployToolHome+"\\config_path.properties")));
			for(Object selectedValue : selectedValues){
			String absPath = path + "\\" + selectedValue + "\\target";
			File newFile = new File(absPath);
			File[] fileList = newFile.listFiles();
			File sourceFile = null;
			for(File ff : fileList){
				if(ff.isFile()){
					if(ff.getName().endsWith("jar") && !(ff. getName().contains("sources") || ff. getName().contains("test"))){
						sourceFile = ff;
					}
				}
			}
			String sourcepath= sourceFile.getAbsolutePath();
			String destPath=p.getProperty("WORKBENCH_PATH");
			File destLoc = new File(destPath+"\\WEB-INF\\lib");
			File[] getFile = destLoc.listFiles();
			File fileTobeDeleted= null;
			for(File ff : getFile){
				if(ff.isFile()){
					if(ff.getName().endsWith("jar") && ff. getName().contains(selectedValue.toString())){
						fileTobeDeleted = ff;
					}
				}
			}
			if(fileTobeDeleted != null)
			fileTobeDeleted.delete();
	
			Runtime.getRuntime().exec("cmd /c copy "+ sourcepath + " " + destLoc);
			boolean fileCopied = false;
			do{
					File[] files = destLoc.listFiles();
					for(File f :files){
						if(f.getName().equals(sourceFile.getName()) && f.lastModified() == sourceFile.lastModified()){
							fileCopied = true;
							InfoDialog dialog = new InfoDialog(this, "INFO",sourceFile. getName()+" Copied Successfully");
							dialog.setSize(500, 100);
							dialog.show(true);
							break;
						}
					}
				}while(!fileCopied);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void buildBtnActionPerformed(java.awt.event.ActionEvent evt)
			throws FileNotFoundException {
		
		File f = new File(deployToolHome+"\\maven_build.bat");
		FileOutputStream fos = new FileOutputStream(f);
		String path = (String) deployUtil.getProp().get(
				projectListComboBox.getSelectedItem());
		Object[] selectedValues = (Object[]) jList1.getSelectedValues();
		if(buildAndCopyFlag){
			projectBuilding = path;
			selectedVals = selectedValues;
		}
		StringBuilder command = new StringBuilder();
		if (selectedValues != null && selectedValues.length > 0) {
			for (Object selecteValue : selectedValues) {
				String absPath = path + "\\" + selecteValue;
				try {
					command.append(absPath.substring(0,2) + "\r\n");
					command.append("cd " + absPath + "\r\n");
					command.append("call mvn");
					if (jRadioButton1.isSelected()) {
						command.append(" -o");
					} else {
						command.append(" -U");
					}

					command.append(" clean install");
					if (skipTestsCheckBox.isSelected()) {
						command.append(" " + skipTests);
					}

					if (skipDatabaseCheckBox.isSelected()) {
						command.append(" " + skipDatabase);
					}
					command.append(" > "+deployToolHome+"\\error_log.txt");
					command.append("\r\n");
					command.append("type "+deployToolHome+"\\error_log.txt");
					command.append("\r\n");
					command.append("exit");
					command.append("\r\n");
				} catch (Exception e) {

				}
			}
		}
		
		byte[] b = new byte[command.length()];
		b = command.toString().getBytes();
		try {
			fos.write(b);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File f1 = new File(deployToolHome+"\\error_log.txt");
			if(f1.exists()){
				f1.delete();
				f1.createNewFile();
			}
			FileInputStream fis = new FileInputStream(f1);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			Process p = Runtime.getRuntime().exec(
					"cmd /c start /MIN "+deployToolHome+"\\maven_build.bat");
//			Long buildStarttime = System.currentTimeMillis();
			
			String s;
			while(true){
				s= br.readLine();
				if(s != null){
					if(s.contains("BUILD SUCCESS") || s.contains("BUILD FAILURE")){
						break;
					}
				}
			}
			
//			String absPath = path + "\\" + selectedValues[0] + "\\target";
//			File fileToCheck = new File(path);
//			boolean buildStatus = false;
//			while(!buildStatus){
//				if(fileToCheck != null && fileToCheck.exists()){
//				 File[] files = fileToCheck.listFiles();
//				 for(File file : files){
//					 if(file.getName().endsWith("jar")){
//						 Long lastModifiedTime = file.lastModified();
//						 if(lastModifiedTime > buildStarttime){
//							 buildStatus =  true;
//							 break;
//						 }
//					   }
//				 	}
//				}
//			}
//			fis.close();
//			br.close();
//			System.out.println(s);
			String project = (String) selectedValues[0];
			
//			if(buildStatus){
//				InfoDialog dialog = new InfoDialog(this, "INFO",project +" Build Successfully");
//				dialog.setSize(300, 100);
//				dialog.show(true);
//			}else
//			if(s.contains("BUILD FAILURE")){
//				InfoDialog dialog = new InfoDialog(this, "INFO",project +" Build Failed" + " Please see error logs");
//				dialog.setSize(300, 100);
//				dialog.show(true);
//			}
			if(s.contains("BUILD SUCCESS")){
				InfoDialog dialog = new InfoDialog(this, "INFO",project +" Build Successfully");
				dialog.setSize(300, 100);
				dialog.show(true);
			}else if(s.contains("BUILD FAILURE")){
				InfoDialog dialog = new InfoDialog(this, "INFO",project +" Build Failed" + " Please see error logs");
				dialog.setSize(300, 100);
				dialog.show(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void EditPreferencesBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		EditPreferencesDialog editPreferencesJFrame = new EditPreferencesDialog(this,true);
		editPreferencesJFrame.setVisible(true);
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		String path = (String) deployUtil.getProp().get(
				projectListComboBox.getSelectedItem());
		File f = new File(path);
		ArrayList<String> aList = new ArrayList<String>();
		if (f.exists()) {
			File[] fileList = f.listFiles();
			for (File file : fileList) {
				if (file.isDirectory()) {
					aList.add(file.getName());
				}
			}
		}
		jList1.setListData(aList.toArray());
	}
	
	private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {
		refreshList();
	}
	
	private void refreshList(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(this.getDeployToolHome()+"\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<Object> properties= prop.keySet();
		 Object list[] = properties.toArray();
		 projectListComboBox.setModel(new javax.swing.DefaultComboBoxModel(list));
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try{
			for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
				if("Nimbus".equalsIgnoreCase(info.getName())){
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DeployToolFrame deployToolFrame = new DeployToolFrame();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				deployToolFrame.setLocation(screenSize.width/5, screenSize.height/7);
				deployToolFrame.setVisible(true);
				
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem EditPreferencesBtn;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton buildBtn;
	private javax.swing.JButton buildAndCopyBtn;
	private javax.swing.JButton copyBtn;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton startJBossBtn;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox skipDatabaseCheckBox;
	private javax.swing.JCheckBox skipTestsCheckBox;
	private javax.swing.JCheckBox clearTempCheckBox;
	private javax.swing.JComboBox projectListComboBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JList jList1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem editWorkbench;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	// End of variables declaration//GEN-END:variables

}