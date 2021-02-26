-DsuiteXmlFile=TestNG.xml
# Author: Orysia Rusanovska
Project includes:
*lesson1:*
Reviewed:
working with TestNG
- Before/After suite/test/class/method

- Testng xml
-- structure
-- parallel
-- parameter passing

Java
-- functional interface

Selenium
- alerts
- page object

Homework:
Selenium
- Selenium grid
- files upload download

*lesson2:*
 	Reviewed:
Selenium
- Selenium grid
- files upload download

Homework:
- RestAssured for testing REST API
- Selenium to retrieve element by multple locators
- Maven to pass parameters from command line

*lesson3:*
 	Homework
* Creating factory for drivers
* Attach allure report to site
* Add few parameters inside testNG.xml
* Add parameters for @BeforeSuite method
* Update parallel run in surefire plugin
* Create only one BaseTest class

*lesson4:*
 	Homework:
- software development patterns in automation: Abstract factory, factory method, builder, static factorty method (java), adapter, bridge, facade, decorator, proxy, observer, iterator
- SOLID principles



5. For starting Selenium Grid:
- open cmd
- switch to F:
cd IT\Mentorship\src\test\java\drivers\seleniumStandaloneServer
- type: java -jar selenium-server-standalone-3.141.59.jar -role hub
- navigate to http://yourIPadress:4444/grid/console/
- to start nodes
java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://yourIPadress:4444/grid/register -port 5556
java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://yourIPadress:4444/grid/register -port 5557
or
java -Dwebdriver.chrome.driver-F:\IT\Mentorship\src\test\java\drivers\chrome_89_0_4389_23\chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -port 5555 -hub http://yourIPadress:4444/grid/register/
java -Dwebdriver.chrome.driver-F:\IT\Mentorship\src\test\java\drivers\chrome_89_0_4389_23\chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -port 5556 -hub http://yourIPadress:4444/grid/register/
or
java -Dwebdriver.chrome.driver-F:\IT\Mentorship\src\test\java\drivers\chrome_88_0_4324_96\chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -port 5555 -hub http://yourIPadress:4444/grid/register/
or
java -Dwebdriver.chrome.driver-F:\IT\Mentorship\src\test\java\drivers\chrome_88_0_4324_96\chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -port 5555 -hub http://yourIPadress:4444/grid/register/ -browser "browserName=chrome, version=88.0.4324.96, maxInstances=10, platform=WIN10"
6. MAVEN
clean site
or
navigate to cd F:\IT\Mentorship\src\test\java\utils\lesson3\ (.bat file directory)
enter testNGBatchFile.bat (.bat file name)