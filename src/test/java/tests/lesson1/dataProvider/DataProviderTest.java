package tests.lesson1.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.lesson1.calculator.BaseCalculatorPage;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.TreeMap;

public class DataProviderTest {
    BaseCalculatorPage testObject = new BaseCalculatorPage();

    @DataProvider(parallel = true, name = "data-provider")
    public Object[][] dataPr(Method name) {
        switch (name.getName()) {
            case "dataProviderTest1":
                return new Object[][]
                        {{2, 10, 6, 2},
                                {4, 20, 16},
                                {9, 30, 7, 13, 1}};
            case "dataProviderTest2":
                return new Object[][]
                        {{40, 10, 21, 9},
                                {45, 9, 9, 9, 9, 9},
                                {9, 3, 6}};
            case "dataProviderTest3":
                return new Object[][]
                        {{100, 10, 10},
                                {8, 2, 2, 2},
                                {9, 3, 3}};
            case "dataProviderTest4":
                return new Object[][]
                        {{5, 45, 9},
                                {100, 1000, 2, 5},
                                {9, 27, 3}};
        }
        return null;
    }


    @Test(dataProvider = "data-provider", description = "test annotation: calculaorTest1, check subtraction ")
    public void dataProviderTest1(int expectedResult, int... numbers) {
        testObject.checkingSubtraction("The subtract method has wrong implementation", expectedResult, numbers);
        System.out.println("+++This is dataProviderTest1");
    }

    @Test(dataProvider = "data-provider", description = "test annotation: calculatorTest1, check addition ")
    public void dataProviderTest2(int expectedResult, int... numbers) {
        testObject.checkingAddition("The subtract method has wrong implementation", expectedResult, numbers);
        System.out.println("+++This is dataProviderTest2");
    }

    @Test(dataProvider = "data-provider", description = "test annotation: calculatorTest1, check multiplication ")
    public void dataProviderTest3(int expectedResult, int... numbers) {
        testObject.checkingMultiplication("The subtract method has wrong implementation", expectedResult, numbers);
        System.out.println("+++This is dataProviderTest3");
    }

    @Test(dataProvider = "data-provider", description = "test annotation: calculatorTest1, check division ")
    public void dataProviderTest4(int expectedResult, int... numbers) {
        testObject.checkingDivision("The subtract method has wrong implementation", expectedResult, numbers);
        System.out.println("+++This is dataProviderTest4");
    }
}
