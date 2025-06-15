

package com.TestingShastra;

public interface Locators {
 String userName="//input[@name=\"username\"]";
 String passWord="//input[@name=\"password\"]";
 String loginBtn="//button[@type=\"submit\"]";
 String dashBoard="//h6[text()='Dashboard']";
 String LoginErrorMsg="//p[text()='Invalid credentials']";
}
 
// //interface ke all variables bydefault public,static and final hote he.
// 
// //properties file:-
// //properties file is a simple text file which always stored data in key and value pair
// //as well as in this file key and value both are bydefault in string. 
// //New --> File --> <FileName>.properties
// //to handle properties file java provided one class i.e "Properties"
// //under this property file we can store locators,Environment details,browsers,testdata and call this component from property file
// //property file always make in src/main/resources
// //class and interface having bytecode and it is not changeable.
// //properties file is a simple file having no bytecode, and we can change it anytime on jenkins server
