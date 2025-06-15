package com.features;

import com.TestingShastra.KeyWord;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DataProviderDefSwagLabs {
	KeyWord key=new KeyWord();
	
	@Given("Launch chrome Browser for to test Swag Labs")
	public void launch_chrome_browser_for_to_test_swag_labs() {
		key.LaunchBrowser("chrome");
	}

	@Given("Enter valid Swag Labs app url")
	public void enter_valid_swag_labs_app_url() {
		key.ImplicitWait();
		key.launchURL("");

	}

	@When("Enter valid userName {string} for Swag Labs")
	public void enter_valid_user_name_for_swag_labs(String username) {
	

	}

	@When("Enter valid passWord {string} for Swag Labs")
	public void enter_valid_pass_word_for_swag_labs(String password) {

	}

	@When("Click on login button Swag Labs")
	public void click_on_login_button_swag_labs() {

	}
}
