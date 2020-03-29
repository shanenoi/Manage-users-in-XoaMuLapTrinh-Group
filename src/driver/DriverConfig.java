package driver;

import java.util.HashMap;
import java.util.Map;

public class DriverConfig {
	
	public String mail = "automail.robort@yandex.com";
	public String pass = "fGwk093oiVtdJPuc8z2wtFjGcvzSi6eonkvWTjZa8glIE6uYJdvLTJv9dJWJVDgMy68Bozma3kKGkWDw";
	public String chrome_drive_link = "/home/shanenoi/Desktop/Selenium/WebDriver/chromedriver";
	@SuppressWarnings("serial")
	public Map<String, Object> prefs = new HashMap<String, Object>(){{
		put("profile.default_content_setting_values.notifications", 2);
	}};

}
