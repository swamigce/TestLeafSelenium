package steps;

import org.openqa.selenium.remote.RemoteWebDriver;

public class CucumberBase {
	public static RemoteWebDriver driver;
	private static final ThreadLocal<RemoteWebDriver> localDriver = new ThreadLocal<RemoteWebDriver>();
	public void setUp(RemoteWebDriver driver) {
		localDriver.set(driver);
	}

	public RemoteWebDriver getDriver() {
		return localDriver.get();
	}

}
