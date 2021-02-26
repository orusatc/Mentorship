package tests.lesson1.calculator;

import org.testng.annotations.Test;
import pages.lesson1.calculator.BaseCalculatorPage;
import pages.lesson1.calculator.BaseCalculatorPrintResult;

public class CalculatorTest extends BaseCalculatorPrintResult {
    BaseCalculatorPage testObject = new BaseCalculatorPage();


    @Test(groups = "1", description = "test annotation: calculaorTest1, check subtraction ")
    public void calculatorTest1() {
        testObject.checkingSubtraction("The subtract nethod has wrong implementation", 3, 10, 6, 1);
        System.out.println("+++This is calculatorTest1");
    }

    @Test(groups = "2",description = "test annotation: calculaorTest2, check addition ")
    public void calculatorTest2() {
        testObject.checkingAddition("The subtract nethod has wrong implementation", 20, 10, 6, 4);
        System.out.println("+++This is calculatorTest2");
    }

    @Test(groups = "1", description = "test annotation: calculaorTest3, check multiplication ")
    public void calculatorTest3() {
        testObject.checkingMultiplication("The subtract nethod has wrong implementation", 75, 5, 5, 3);
        System.out.println("+++This is calculatorTest3");
    }

    @Test(groups = "3", description = "test annotation: calculaorTest4, check division ")
    public void calculatorTest4() {
        testObject.checkingDivision("The subtract nethod has wrong implementation", 50, 100, 2);
        System.out.println("+++This is calculatorTest4");
    }
}
