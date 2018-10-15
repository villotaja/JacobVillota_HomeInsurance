package jacob.casestudy.SeleniumTest;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class LoginTest {

	
	@Test
	public void LoginTestFail() { //Login fail username only
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		textbox.sendKeys("jacobjacob");
		textbox.submit();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage"));
		driver.close();
	
	}
	@Test
	public void LoginTestFail2() { // Login Fail with password only
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("pwd"));
		WebElement textbox = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox.submit();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage"));
		driver.close();
		driver.quit();
	}
	@Test
	public void LoginTestPass()  { //Login test to pass
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/Home.jsp"));
		driver.close();
		driver.quit();
	}
	@Test
	public void LoginTestFail3()  { //Login test to fail both user and pwd mismatch
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("lkjad");
		textbox2.sendKeys("jsdaas");
		textbox.submit();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage"));
		driver.close();
		driver.quit();
}
	@Test
	public void LoginTestFail4()  { //Login test to fail  pwd and pass user
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jsdaas");
		textbox.submit();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage"));
		driver.close();
		driver.quit();
}
	@Test
	public void Sendtoregisteruser()  { //Sends to the new user page
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();		
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/newUser.jsp"));
		driver.close();
		driver.quit();
}
}
