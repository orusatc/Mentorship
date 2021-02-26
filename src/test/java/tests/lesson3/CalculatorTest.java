package tests.lesson3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.lesson1.calculator.BaseCalculatorPage;
import pages.lesson1.calculator.BaseCalculatorPrintResult;

import java.util.Collection;
import java.util.TreeMap;

public class CalculatorTest extends BaseCalculatorPrintResult {
    BaseCalculatorPage testObject = new BaseCalculatorPage();

    @Test(description = "test annotation: calculatorTest1, check addition ")
    @Parameters({"result", "num"})
    public void parametersFromTestNG(int expectedResult, String numbers) {
        //need parse to get input data
        numbers = numbers.replaceAll("\\s+", "");
        String inputArray[] = numbers.split(",");

        //approach1
        int[] inputNumbers = new int[inputArray.length];
        for(int i = 0; i < inputNumbers.length; i++){
            inputNumbers[i] = Integer.parseInt(inputArray[i]);
        }

        //approach2
//        TreeMap<Integer, Integer> inputNumbersMap = new TreeMap<>();
//        for (int i = 0; i < inputArray.length; i++) {
//            inputNumbersMap.put(i, Integer.parseInt(inputArray[i]));
//        }
//        Collection<Integer> values = inputNumbersMap.values();
//        Integer[] inputNumbersInteger = values.toArray(new Integer[0]);
//        int[] inputNumbers = new int[inputNumbersInteger.length];
//        for(int i = 0; i<inputNumbers.length; i++){
//            inputNumbers[i] = inputNumbersInteger[i].intValue();
//        }

        testObject.checkingAddition("The subtract method has wrong implementation", expectedResult, inputNumbers);
        System.out.println("+++This is dataProviderTest2");
    }

}
