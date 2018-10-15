package jacob.casestudy.SeleniumTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewUserTest {

	@Test
	public void NewUserTestFail1()  { //User name to short
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("newUser")).sendKeys("thisusernameiswaytolongwhatareyoudoingwithyourself");
		driver.findElement(By.name("newpassword")).sendKeys("longenough");
		driver.findElement(By.name("repwd")).sendKeys("longenough");
		driver.findElement(By.name("reg")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/RegUser"));
		driver.close();
		driver.quit();
}

	@Test
	public void NewUserTestFail2()  { //password to short
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("newUser")).sendKeys("longenough");
		driver.findElement(By.name("newpassword")).sendKeys("little");
		driver.findElement(By.name("repwd")).sendKeys("little");
		driver.findElement(By.name("reg")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/RegUser"));
		driver.close();
		driver.quit();
}
	@Test
	public void NewUserTestFail3()  { //password mismatch
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("newUser")).sendKeys("longenough");
		driver.findElement(By.name("newpassword")).sendKeys("little");
		driver.findElement(By.name("repwd")).sendKeys("longenough");
		driver.findElement(By.name("reg")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/RegUser"));
		driver.close();
		driver.quit();
}
	@Test
	public void NewUserTestFail4()  { //Bad characters in users
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("newUser")).sendKeys("$$$$$$$$");
		driver.findElement(By.name("newpassword")).sendKeys("longenough");
		driver.findElement(By.name("repwd")).sendKeys("longenough");
		driver.findElement(By.name("reg")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/RegUser"));
		driver.close();
		driver.quit();
}
	@Test
	public void NewUserTestFail5()  { //Bad characters in password
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("newUser")).sendKeys("Hellothere");
		driver.findElement(By.name("newpassword")).sendKeys("$$$$$$$$");
		driver.findElement(By.name("repwd")).sendKeys("$$$$$$$$");
		driver.findElement(By.name("reg")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/RegUser"));
		driver.close();
		driver.quit();
}
	@Test 
	public void NewUserTestPass()  { //Sends to the new user page
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp");
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("newUser")).sendKeys("propertyman21");
		driver.findElement(By.name("newpassword")).sendKeys("Horses1516");
		driver.findElement(By.name("repwd")).sendKeys("Horses1516");
		driver.findElement(By.name("reg")).click();
		assertThat(driver.getCurrentUrl(),is("http://localhost:8080/HomeOwnerInsuranceApp/View/LoginPage.jsp"));
		driver.close();
		driver.quit();
}



}
