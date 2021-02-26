package tests.lesson1.beforeAfterSuiteTestClassMethod;

import org.testng.annotations.*;

public class BeforeAfterSuiteTestClassMethod {

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println("***This is beforeSuite()");
    }

    @BeforeTest()
    public void beforeTest() {
        System.out.println("*****This is beforeTest()");
    }

    @BeforeClass()
    public void beforeClass() {
        System.out.println("*******This is beforeClass()");
    }

    @BeforeMethod()
    public void beforeMethod() {
        System.out.println("*********This is beforeMethod()");
    }

    @BeforeGroups()
    public void beforeGroups() {
        System.out.println("***********This is beforeGroups()");
    }

    @AfterSuite()
    public void afterSuite() {
        System.out.println("***This is afterSuite()");
    }

    @AfterTest()
    public void afterTest() {
        System.out.println("*****This is afterTest()");
    }

    @AfterClass()
    public void afterClass() {
        System.out.println("*******This is afterClass()");
    }

    @AfterMethod()
    public void afterMethod() {
        System.out.println("*********This is afterMethod()");
    }

    @AfterGroups()
    public void afterGroups() {
        System.out.println("***********This is afterGroups()");
    }

    @Test(groups= "group3", description = "description annotation: Test1 Before\\After suite, test, class, method, groups")
    public void testMethod1() {
        System.out.println("+++This is testMethod1()");
    }


    @Test(groups= "group2",description = "description annotation: Test2 Before\\After suite, test, class, method, groups")
    public void testMethod2() {
        System.out.println("+++This is testMethod2()");
    }

    @Test(groups= "group1", description = "description annotation: Test3 Before\\After suite, test, class, method, groups")
    public void testMethod3() {
        System.out.println("+++This is testMethod3()");
    }
}
