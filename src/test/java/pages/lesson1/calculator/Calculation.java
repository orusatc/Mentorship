package pages.lesson1.calculator;

import java.util.Optional;

public interface Calculation {
    default void startCalculation(){
        System.out.println("We are going to count with Calculator help");
    }

    public int calculate(int... numbers);

}
