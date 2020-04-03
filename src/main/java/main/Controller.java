package main;

import driver.DriverConfig;
import driver.WebDriver;
import xmlt.XoaMuLapTrinhPosts;

public class Controller {
	
	static int sleepTime = 2000;

	public static void main(String[] args) throws Exception {
		
		DriverConfig config = new DriverConfig();
		WebDriver driver = new WebDriver(config);
		driver.startChromeDriver();
		XoaMuLapTrinhPosts posts = new XoaMuLapTrinhPosts(driver.webdriver);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		posts.loadMore();
		Thread.sleep(sleepTime);
		System.out.println(posts.list().size());
		System.out.println("done");

	}

}
