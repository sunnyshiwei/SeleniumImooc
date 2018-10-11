package SeleniumImooc.SeleniumImooc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	public WebDriver driver;
	
	public String idStr="id";
	public String nameStr="name";
	public String classNameStr="className";
	public String cssSelectorStr="cssSelector";
	public String linkTextStr="linkText";
	public String partialLinkTextStr="partialLinkText";
	public String tagNameStr="tagName";
	public String xpathStr="xpath";

	public void InitDriver(){
		
        System.setProperty("webdriver.gecko.driver","F:\\selenium\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        System.setProperty ("webdriver.firefox.bin" , "C:/Program Files (x86)/Mozilla Firefox/firefox.exe" );
        
		driver = new FirefoxDriver();
		driver.get("https://www.imooc.com/");
		driver.manage().window().maximize();		
		//点击登录按钮
		driver.findElement(By.id("js-signin-btn")).click();
	}

	public void LoginScript(String userName,String passWord) throws InterruptedException{
		
		//String emailElement="email";
		//String passwordElement="password";
		//String xpathElement=".//*[@id='signup-form']/div[5]/input";
 		//String headerElement="header-avator";
 		//String nameElement="name";
 	
		Thread.sleep(2000);
		//定位输入框
		WebElement user=this.driverElement(this.byString("userName"));
		user.isDisplayed();
		WebElement password=this.driverElement(this.byString("passWord"));
		user.isDisplayed();
		WebElement loginButton=this.driverElement(this.byString("loginbutton"));
		loginButton.isDisplayed();
		user.sendKeys(userName);
		password.sendKeys(passWord);
		loginButton.click();		
		Thread.sleep(3000);
		WebElement userStatus=this.driverElement(this.byString("userstatus"));
		userStatus.isDisplayed();
		//鼠标悬停
		Actions action = new Actions(driver);		
		action.moveToElement(userStatus).perform();;
		Thread.sleep(2000);
		String username=this.driverElement(this.byString("username")).getText();
		System.out.println(username);
		
		if(username.equals("微微要学自动化")){
			System.out.println("慕课网登录成功!!");
		}else {
			System.out.println("慕课网登录失败!!");
		}
	
	}
	public static void main(String[] args) throws InterruptedException{
		Login login=new Login();
		login.InitDriver();
		login.LoginScript("13998538053","1qaz2wsx");
		/*
		 * Key-value
		 * username-password
		 * */
		//初始化
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("13998538053", "1qaz2wsx");
		user.put("13998538053@163.com", "1qaz2wsx");
		Iterator us =user.entrySet().iterator();
		while(us.hasNext()){
			Map.Entry entry=(Map.Entry) us.next();
		}
		
	
	}
	/*封装By by
	 * 方法中byString(String key) by为定位方式id,name,className等等
	 * local为当前*/
	 public By byString(String key){
		 
		ProUtils properties= new ProUtils("element.properties");		
		String locator=properties.getPro(key);
		String locatorType=locator.split(">")[0];//定位方式是：element.properties文件中userName=name>email 的name
		String locatorValue=locator.split(">")[1];//定位值是：element.properties文件中userName=name>email 的email
		
		if(locatorType.equals("id")){
			return By.id(locatorValue);
		}else if(locatorType.equals("name")){
			return By.name(locatorValue);	
		}else if(locatorType.equals("className")){
			return By.className(locatorValue);
		}else if(locatorType.equals("cssSelector")){
			return By.cssSelector(locatorValue);
		}else if(locatorType.equals("linkText")){
			return By.linkText(locatorValue);
		}else if(locatorType.equals("partialLinkText")){
			return By.partialLinkText(locatorValue);
		}else if(locatorType.equals("tagName")){
			return By.tagName(locatorValue);
		}else {
			return By.xpath(locatorValue);
		}	
	 }
	 /*
	  * 封装Element
	  * **/
	 public WebElement driverElement(By by){
		 WebElement ele=driver.findElement(by);
		 return ele;
	 }
	
}
