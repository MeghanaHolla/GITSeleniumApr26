package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelMar29\\TestData.xlsx", "Sheet2");
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowserWindow();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToAUT":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clickSignInButton(data[i][4],data[i][5]);
				break;
			case "verifyMessage":
				String actualMsg = Methods.getErrorMessage(data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApplication":
				Methods.closeAUT();
				break;
			}
		}
	}

}
