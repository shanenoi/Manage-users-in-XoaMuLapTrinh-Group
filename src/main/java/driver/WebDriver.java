package driver;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriver {
	
	public ChromeDriver webdriver;
	public DriverConfig config = null;
	
	public WebDriver(DriverConfig config) {
		this.config = config;
	}
	
	public void startChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", this.config.prefs);
		System.setProperty("webdriver.chrome.driver", this.config.chrome_drive_link);
		this.webdriver = new ChromeDriver(options);
		this.login_and_goto_xmlt(/*this.config.mail, this.config.pass*/);
	}
	
	private void login_and_goto_xmlt(/*String mail, String password*/) {
		this.webdriver.get("https://www.facebook.com/groups/xoamulaptrinh/");
		/*WebElement email = this.webdriver.findElementById("email");
		WebElement pass = this.webdriver.findElementById("pass");
		WebElement summit = this.webdriver.findElementById("u_0_2");
		email.clear(); email.sendKeys(mail);
		pass.clear(); pass.sendKeys(password);
		summit.click();*/
	}

}
