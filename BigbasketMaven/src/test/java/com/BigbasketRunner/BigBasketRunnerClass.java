package com.BigbasketRunner;


import com.BigBasketBase.BibasketBaseClass;
import com.BigbasketDataReader.ConfigReader;
import com.BigbasketPOM.BigbasketLoginPom;


public class BigBasketRunnerClass extends BibasketBaseClass{
	
	BigbasketLoginPom ln ;
	
	private void gethomepage(){
		
		ConfigReader cr = new ConfigReader();
		browserLaunch(cr.getBrowser());
		launchUrl(driver, cr.getUrl(), 20);
	}
	
	private void getloginpage(){
		
		ln = new BigbasketLoginPom(driver);
		ln.loginpage();
		
	}
	
	private void getverifyloginpage() {
		
		ln = new BigbasketLoginPom(driver);
		ln.verifylogin();

	}
	public static void main(String[] args) {
		
		BigBasketRunnerClass run = new BigBasketRunnerClass();
		run.gethomepage();
		run.getloginpage();
		run.gethomepage();
		run.getverifyloginpage();
	}
}
