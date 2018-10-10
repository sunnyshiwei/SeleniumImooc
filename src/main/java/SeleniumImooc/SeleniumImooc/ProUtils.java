package SeleniumImooc.SeleniumImooc;

import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtils {
	private Properties prop;
	private String filePath;
	
	/*构造方法*/
	public ProUtils(String filePath) {
		this.filePath = filePath;
		this.prop=readProperties();
	}

	/*读取配置文件*/
	private Properties readProperties(){
		Properties properties = new Properties();
		//读取文件FileInputStream("element.properties");并放在缓存中
		try {
			InputStream inputStream =new FileInputStream(filePath);
			BufferedInputStream in = new BufferedInputStream(inputStream);
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return properties;
	}
	
	public String getPro(String key) {
		if(prop.containsKey(key)){
			String keyName=prop.getProperty(key);
			return keyName;
		}else{
			System.out.println("你获取的key值不正确");
			return "";
		}

		
	}


	

}
