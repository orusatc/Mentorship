package pages.lesson1.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AdditionPage implements Calculation{
    @Override
    public int calculate(int... numbers) {
        Integer[] inputValue = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            inputValue[i] = new Integer(numbers[i]);
        }
        List<Integer> list = Arrays.asList(inputValue);
        Optional<Integer> sum = list.stream()
                .reduce((left, right) -> left + right);
        int result = Integer.valueOf(sum.get());
        return result;
    }
}
