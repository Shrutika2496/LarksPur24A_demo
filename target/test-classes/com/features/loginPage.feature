Feature: This feature file contains Login page test(DataProvider example)

Scenario: To verify Login with multiple credentials
Given Launch chrome Browser for to test Swag Labs
And Enter valid Swag Labs app url
When Enter valid userName"<username>" for Swag Labs
And Enter valid passWord "<password>" for Swag Labs
And Click on login button Swag Labs
And browser should be closed for Swag Labs

Examples: this is data for user and password
|username               |password    |
|standard_user          |secret_sauce|
|locked_out_user        |secret_sauce|
|problem_user           |secret_sauce|
|performance_glitch_user|secret_sauce|
|error_user             |secret_sauce|
|visual_user            |secret_sauce|


Background:
#it is used kept common code i.e same code(Reusable code which is used in multiple test cases)



