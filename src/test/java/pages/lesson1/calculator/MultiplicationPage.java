package pages.lesson1.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MultiplicationPage implements Calculation {
    @Override
    public int calculate(int... numbers) {
        Integer[] numbersArray = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersArray[i] = new Integer(numbers[i]);
        }
        List<Integer> list = Arrays.asList(numbersArray);

        Optional<Integer> divided = list.stream()
                .reduce((left, right) -> left * right);
        int result = Integer.valueOf(divided.get());
        return result;
    }
}
