package main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class DeployUtil {
	
	private Properties prop;
	
	public Object[] getPropertiesList(String filePath) throws FileNotFoundException, IOException{
//		prop.load(new FileInputStream("c:\\config.properties"));
//		loadPropertiesFile(filePath);
		String deployToolHome;
		
		
		File deployToolHomeFileC = new File("C:\\DeployTool");
		File deployToolHomeFileD = new File("D:\\DeployTool");
		File deployToolHomeFileE = new File("E:\\DeployTool");
		
		if(deployToolHomeFileC.exists()){
			deployToolHome="C:\\DeployTool";
		}else if(deployToolHomeFileD.exists()){
			deployToolHome="D:\\DeployTool";
		}else if(deployToolHomeFileE.exists()){
			deployToolHome="E:\\DeployTool";
		}else{
			deployToolHome= System.getenv("DEPLOY_HOME");
		}

		loadPropertiesFile(deployToolHome+"\\config.properties");
		Set<Object> properties= prop.keySet();
		Object list[] = properties.toArray();
		return list;
	}

	public Properties getProp() {
		if(prop == null){
			prop = new Properties();
		}
		return prop;
	}

	public Properties loadPropertiesFile(String filePath) throws FileNotFoundException, IOException{
		getProp().load(new FileInputStream(filePath));
		return prop;
	}
	
}
