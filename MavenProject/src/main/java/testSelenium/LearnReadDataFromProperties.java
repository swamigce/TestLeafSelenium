package testSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearnReadDataFromProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fs = new FileInputStream("./src/main/resources/config.properties");
		Properties prop= new Properties();
		prop.load(fs);
		String strPropValue = prop.getProperty("userName");
		System.out.println("Pring prop value = "+strPropValue);
		fs.close();

		
	}

}
