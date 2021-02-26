package pages.lesson1.calculator;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class BaseCalculatorPage extends BaseCalculatorPrintResult {
    private Calculation ob1;
    private Calculation ob2;
    private Calculation ob3;
    private Calculation ob4;
    private int result;

    public BaseCalculatorPage() {
        this.ob1 = new MultiplicationPage();
        this.ob2 = new AdditionPage();
        this.ob3 = new DivisionPage();
        this.ob4 = new SubtractionPage();
    }

    public BaseCalculatorPage checkResult(Calculation object, String message, int expectedResult, int... numbers) {
        result = object.calculate(numbers);
        assertEquals(expectedResult, result, message);
        showingTheResult.calculationResults(result);
        return this;
    }


    @Step("Checking multiplication")
    public BaseCalculatorPage checkingMultiplication(String message, int expectedResult, int... numbers) {
        checkResult(ob1, message, expectedResult, numbers);
        return this;
    }

    @Step("Checking addition")
    public BaseCalculatorPage checkingAddition(String message, int expectedResult, int... numbers) {
        checkResult(ob2, message, expectedResult, numbers);
        return this;
    }


    @Step("Checking division")
    public BaseCalculatorPage checkingDivision(String message, int expectedResult, int... numbers) {
        checkResult(ob3, message, expectedResult, numbers);
        return this;
    }

    @Step("Checking subtraction")
    public BaseCalculatorPage checkingSubtraction(String message, int expectedResult, int... numbers) {
        checkResult(ob4, message, expectedResult, numbers);
        return this;
    }
}
