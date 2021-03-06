# xeQAChallenge
The project uses Java 8, TestNG, Selenium and builds with maven.

Your machine must have the corresponding JDK installed, maven will deal with the rest dependencies, which can be seen in the pom file.

The runnable test is TestExample.java in package gr.xe.selenium.qaChallenge.

In the folder resources you may find the web driver executables, chromedriver and chromedriver.exe. chromedriver is for linux,
while chromedriver.exe can be used for windows.

The default configuration of this project is to run in Windows, with chrome 93.0.4577.63

If you want to use another version of chrome you must replace the executable in resources with the corresponding one. You may find all the
available chromedriver versions here https://chromedriver.chromium.org/downloads

If you want to run the project in linux, you must go to TestExample.java and change chromeDriverPath from
path + "/src/main/resources/chromedriver.exe" to path + "/src/main/resources/chromedriver". This also applies for
the other test included in the project.

If you want to use another browser, add the web driver executable in the folder resources and make the necessary adjustments in TestExample.
E.g. to use firefox you need to place GeckoDriver.exe in resources, declare WebDriver driver as FirefoxDriver() and use
System.setProperty("webdriver.gecko.driver", path + "/src/main/resources/GeckoDriver.exe");