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

	public void InitDriver(){
		
        System.setProperty("webdriver.gecko.driver","F:\\selenium\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        System.setProperty ("webdriver.firefox.bin" , "C:/Program Files (x86)/Mozilla Firefox/firefox.exe" );
        
		driver = new FirefoxDriver();
		driver.get("https://www.imooc.com/");
		driver.manage().window().maximize();
	}

	public void LoginScript() throws InterruptedException{
		//点击登录按钮
		driver.findElement(By.id("js-signin-btn")).click();
 		
		Thread.sleep(2000);
		//定位输入框
		WebElement user=driver.findElement(By.name("email"));
		user.isDisplayed();
		WebElement password=driver.findElement(By.name("password"));
		user.isDisplayed();
		WebElement loginButton=driver.findElement(By.xpath(".//*[@id='signup-form']/div[5]/input"));
		loginButton.isDisplayed();
		user.sendKeys("13998538053");
		password.sendKeys("1qaz2wsx");
		loginButton.click();		
		Thread.sleep(3000);
		WebElement userStatus=driver.findElement(By.id("header-avator"));
		userStatus.isDisplayed();
		//鼠标悬停
		Actions action = new Actions(driver);		
		action.moveToElement(userStatus).perform();;
		Thread.sleep(2000);
		String userName=driver.findElement(By.className("name")).getText();
		System.out.println(userName);
		
		if(userName.equals("微微要学自动化")){
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
	
	

}
