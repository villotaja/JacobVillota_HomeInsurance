package jacob.casestudy.SeleniumTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {

	@Test
	public void Hometobuynewquote()  { //Test to login and buy a quote
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		driver.findElement(By.name("quote")).click(); 
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/GetQuote.jsp?quote=Get+a+Quote"));
		driver.close();
		driver.quit();;
	}

	@Test
	public void HometoquoteDetails()  { //Test to get to quote details
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		driver.findElement(By.name("QuoteDets")).click(); 
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/QuoteDetails.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void HometoHome()  { //Test to get from home page to the home page
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		driver.findElement(By.linkText("Home")).click(); 
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/Home.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void HometoGetQuote()  { //Test to get from home to get quotes via the hyperlink
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		driver.findElement(By.linkText("Get Quote")).click(); 
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/GetQuote.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void HometoRetrieveQuote()  { //Test to get from home to Quote Details via hyperlink
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		driver.findElement(By.linkText("Retrieve Quote")).click(); 
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/QuoteDetails.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void HometoMyPolicies()  { //Test to get from home to My policies via hyperlink
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		driver.findElement(By.linkText("My Policies")).click(); 
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/AllPolicies"));
		driver.close();
		driver.quit();;
}	@Test
	public void HometoLogout()  { //Test to get from home to logout
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
	driver.findElement(By.name("uname"));
	WebElement textbox = driver.findElement(By.name("uname"));
	WebElement textbox2 = driver.findElement(By.name("pwd"));
	textbox.sendKeys("jacobjacob");
	textbox2.sendKeys("jacobjacob");
	textbox.submit();
	driver.findElement(By.linkText("Logout")).click(); 
	assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp"));
	driver.close();
	driver.quit();;
}
}