package frameWorkClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage { 
	
	//Declare the Webdriver
	public static WebDriver driver;
		
	//Constructor 
	//To do some configuration and needs to be called the same as the class 
	//Example to check if driver was started, if not then start the driver
	
	public BasePage() {
	if (driver == null) {
		//Set Parameter values
//		String browser = getDataConfigProperties("browser");
//		String URL = getDataConfigProperties("systemUnderTest");
//		String pdriverDir = getDataConfigProperties("driverdir");
		String browser = "chrome";
		String URL = "https://www.guru99.com/";
		String pdriverDir = "C:\\Selenium\\";
		
		// String pdriverDirFireFox = getDataConfigPropeties("driverdirFirefox");
		// String pdriverDirEdge = getDataConfigPropeties("driverdirEdge");

		//check if parameter passed as "Chrome"
		if (browser.equalsIgnoreCase("chrome")) {
		//Set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
		//create an instance of Chrome
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", pdriverDir+"msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	}

	
	//Set the Browser and URL
	
	//Wait Methods: Wait for Element, Wait for Click
	//...Wait for Element
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
	}
	
	//...Wait for Click
	public void waitforClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
	}
	
	// ...Wait for URL
	public void waitForUrl(int elementWait, String urlContains) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.urlContains(urlContains));
	}
	
	//Method:  Get text on Element
	public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
		return elementText;
	}
	
	//Method:  Click on an Element
	public void clickElement(By pLocator) {
		waitforClick(30, pLocator);
		getElement(pLocator).click();
	}
	
	//Method:  Check that Element exists
	
	//Method:  Get Element
	public WebElement getElement(By pLocator) {
		waitforClick(30, pLocator);
		return driver.findElement(pLocator);
	}
	
	
	//Method:  Cleanup e.g. Close driver
	
	//Method:  Enter text in field
	public void enterText(By pLocator, String enterText) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).sendKeys(enterText);
	}
	
	//Method:  Clear text from field
	
	//Method:  Select from drop-down
	
	//Method:  Get text on Method - pass 


}