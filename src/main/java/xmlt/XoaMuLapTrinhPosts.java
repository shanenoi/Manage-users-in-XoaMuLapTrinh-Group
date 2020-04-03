package xmlt;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class XoaMuLapTrinhPosts {
	
	public ChromeDriver webDriver = null;
	public XMLTConfig config = new XMLTConfig();
	
	public XoaMuLapTrinhPosts(ChromeDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void loadMore() {
		JavascriptExecutor jse = (JavascriptExecutor)this.webDriver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	private boolean isdigit(String num) {
		String digit = "1234567890";
		for (String chr: num.split("")) {
			if (digit.indexOf(chr) == -1) {
				return false;
			}
		}
		return true;
	}
	
	private Post extract(RemoteWebElement object) {
		String text = object.getText();
		Post result = new Post();
		result.postObject = object;
		
		//Name
		int index = text.indexOf(this.config.newMenberOrShare);
		result.name = ((index == -1) ?
						text.split("\n")[0]:
						text.substring(0, index)
		);
		
		//content
		List<String> content = new ArrayList<String>();
		String[] temp = text.split("\n");
		for (int i=2; i<temp.length; i++) {
			if (temp[i].compareTo(temp[i+1]) == 0 && isdigit(temp[i])) {
				break;
			} else {
				content.add(temp[i]);
			}
		}
		result.content = String.join(" ", content).strip();
		
		//Reaction
		Pattern pattern = Pattern.compile(this.config.regexReact);
		Matcher matcher = pattern.matcher(text);
		matcher.find();
		result.reactions = Integer.parseInt(matcher.group(1));
		
		//comments
		pattern = Pattern.compile(this.config.regexComments);
		matcher = pattern.matcher(text);
		matcher.find();
		try {
			result.comments = Integer.parseInt(matcher.group(1));
		} catch (IllegalStateException error) {}
		
		//shares
		pattern = Pattern.compile(this.config.regexShares);
		matcher = pattern.matcher(text);
		matcher.find();
		try {
			result.shares= Integer.parseInt(matcher.group(1));
		} catch (IllegalStateException error) {}
		
		return result;
	}

	public List<Post> list() {
		List<Post> result = new ArrayList<Post>();
		@SuppressWarnings("unchecked")
		ArrayList<RemoteWebElement> posts = (ArrayList<RemoteWebElement>) this.webDriver.executeScript(this.config.code);
		for (RemoteWebElement each: posts) {
			result.add(this.extract(each));
		}
		return result;

	}
}