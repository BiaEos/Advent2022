/**
 * Created by: Alyson
 * Date: 12/21/22
 * Time: 1:55 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.Tools;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class LaunchProgram {
    public static <T> void launchProgram(String optionOne, String optionTwo, Class<T> myClass,
                                         String methodOneName, String methodTwoName) {

        Scanner input = new Scanner(System.in);
        System.out.println("Do you want " + optionOne + " or " + optionTwo + " ?");
        String answer = input.next();
        if (answer.equalsIgnoreCase(optionOne)) {
            try {
                myClass.getDeclaredMethod(methodOneName).invoke(null);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else if (answer.equalsIgnoreCase(optionTwo)) {
            try {
                myClass.getDeclaredMethod(methodTwoName).invoke(null);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else if (answer.equalsIgnoreCase("Exit")) {
            System.exit(0);
        } else {
            System.out.println("Please enter " + optionOne + ", " + optionTwo + ", or Exit" );
            launchProgram(optionOne, optionTwo, myClass, methodOneName, methodTwoName);
        }
    }
}
