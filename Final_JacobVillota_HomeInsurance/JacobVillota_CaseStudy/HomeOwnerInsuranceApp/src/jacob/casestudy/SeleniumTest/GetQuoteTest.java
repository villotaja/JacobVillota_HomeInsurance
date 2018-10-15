package jacob.casestudy.SeleniumTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.touch.DownAction;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.internal.ws.transport.http.DeploymentDescriptorParser;

public class GetQuoteTest {

	
	@Test
	public void GetQuotetoHome()  { //Test to get from GetQuote to the home page
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
		driver.findElement(By.linkText("Home")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/Home.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void GetQuotetoGetQuote()  { //Test to get from GetQuote to get quotes via the hyperlink
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
		driver.findElement(By.linkText("Get Quote")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/GetQuote.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void GetQuotetoRetrieveQuote()  { //Test to get from GetQuote to Quote Details via hyperlink
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
		driver.findElement(By.linkText("Retrieve Quote")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/QuoteDetails.jsp"));
		driver.close();
		driver.quit();;
}
	@Test
	public void GetQuotetoMyPolicies()  { //Test to get from GetQuote to My policies via hyperlink
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
		driver.findElement(By.linkText("My Policies")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/AllPolicies"));
		driver.close();
		driver.quit();;
}	
	@Test
	public void GetQuotetoLogout()  { //Test to get from GetQuote to logout
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
	driver.findElement(By.linkText("Logout")).click(); 	
	assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp"));
	driver.close();
	driver.quit();;
}
	@Test
	public void QuoteFail1()  { //Test to fail quote due to bad characters in address line 1 
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
		driver.findElement(By.name("add1")).sendKeys(" ^%&^ I should fail");
		driver.findElement(By.name("add2")).sendKeys("I typed");
		driver.findElement(By.name("state")).sendKeys("I typed");
		driver.findElement(By.name("City")).sendKeys("I typed");
		driver.findElement(By.name("Zip")).sendKeys("12345");
		driver.findElement(By.name("go on")).click();		
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/NewQuote"));
		driver.close();
		driver.quit();
}	
	@Test
	public void QuoteFail2()  { //Test to fail quote due to bad characters in state 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.name("uname"));
		WebElement textbox = driver.findElement(By.name("uname"));
		WebElement textbox2 = driver.findElement(By.name("pwd"));
		textbox.sendKeys("jacobjacob");
		textbox2.sendKeys("jacobjacob");
		textbox.submit();
		Select dropdown = new Select(driver.findElement(By.name("rt")));
		dropdown.selectByVisibleText("condo");
		driver.findElement(By.name("quote")).click();
		driver.findElement(By.name("add1")).sendKeys("Here I am");
		driver.findElement(By.name("add2")).sendKeys("I typed");
		driver.findElement(By.name("state")).sendKeys("%$#");
		driver.findElement(By.name("City")).sendKeys("I typed");
		driver.findElement(By.name("Zip")).sendKeys("12312");
		driver.findElement(By.name("go on")).click();
		Select dropdown2 = new Select(driver.findElement(By.name("RU")));
		dropdown2.selectByVisibleText("Secondary");
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/NewQuote"));
		driver.close();
		driver.quit();
}
	@Test
	public void QuoteFail3()  { //Test to fail quote due to bad characters in city 
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
		driver.findElement(By.name("add1")).sendKeys("Here I am");
		driver.findElement(By.name("add2")).sendKeys("I typed");
		driver.findElement(By.name("state")).sendKeys("Here I am");
		driver.findElement(By.name("City")).sendKeys("%$@");
		driver.findElement(By.name("Zip")).sendKeys("12345");
		driver.findElement(By.name("go on")).click();		
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/NewQuote"));
		driver.close();
		driver.quit();
}
	@Test
	public void QuoteFail4()  { //Test to fail quote due to bad characters in state 
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
		driver.findElement(By.name("add1")).sendKeys("Here I am");
		driver.findElement(By.name("add2")).sendKeys("I typed");
		driver.findElement(By.name("state")).sendKeys("Here I am");
		driver.findElement(By.name("City")).sendKeys("I typed");
		driver.findElement(By.name("Zip")).sendKeys("I typed");
		driver.findElement(By.name("go on")).click();		
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/NewQuote"));
		driver.close();
		driver.quit();
}
	@Test
	public void QuotePass()  { //Test to fail quote due to bad characters in state 
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
		driver.findElement(By.name("add1")).sendKeys("Here I am");
		driver.findElement(By.name("add2")).sendKeys("I typed");
		driver.findElement(By.name("state")).sendKeys("Howdy");
		driver.findElement(By.name("City")).sendKeys("I typed");
		driver.findElement(By.name("Zip")).sendKeys("12345");
		driver.findElement(By.name("go on")).click();		
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/Homeownerinfo.jsp"));
		driver.close();
		driver.quit();
}	

}