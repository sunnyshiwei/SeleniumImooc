package SeleniumImooc.SeleniumImooc;

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

	public void LoginScript() throws InterruptedException{
		String emailElement="email";
		String passwordElement="password";
		String xpathElement=".//*[@id='signup-form']/div[5]/input";
 		String headerElement="header-avator";
 		String nameElement="name";
 		
 		String userName="13998538053";
		String passWord="1qaz2wsx";
 		
		Thread.sleep(2000);
		//定位输入框
		WebElement user=driver.findElement(this.byString(nameStr, emailElement));
		user.isDisplayed();
		WebElement password=driver.findElement(this.byString(nameStr, passwordElement));
		user.isDisplayed();
		WebElement loginButton=driver.findElement(this.byString(xpathStr, xpathElement));
		loginButton.isDisplayed();
		user.sendKeys(userName);
		password.sendKeys(passWord);
		loginButton.click();		
		Thread.sleep(3000);
		WebElement userStatus=driver.findElement(this.byString(idStr, headerElement));
		userStatus.isDisplayed();
		//鼠标悬停
		Actions action = new Actions(driver);		
		action.moveToElement(userStatus).perform();;
		Thread.sleep(2000);
		String username=driver.findElement(this.byString(classNameStr, nameElement)).getText();
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
		login.LoginScript();
		
	}
	/*封装By by
	 * 方法中byString(String by,String local) by为定位方式id,name,className等等
	 * local为当前*/
	 public By byString(String by,String local){
		if(by.equals("id")){
			return By.id(local);
		}else if(by.equals("name")){
			return By.name(local);	
		}else if(by.equals("className")){
			return By.className(local);
		}else if(by.equals("cssSelector")){
			return By.cssSelector(local);
		}else if(by.equals("linkText")){
			return By.linkText(local);
		}else if(by.equals("partialLinkText")){
			return By.partialLinkText(local);
		}else if(by.equals("tagName")){
			return By.tagName(local);
		}else {
			return By.xpath(local);
		}
			
	 }
	

}
