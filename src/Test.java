package src;

public class Test {

    public static void main(String[] args){

        /*double testDouble = InputHelper.getDoubleInput("Das ist der erste Test");
        int testInteger = InputHelper.getIntegerInput("Das ist der zweite Test");
        String testString = InputHelper.getStringInput("Das ist der dritte Test");*/

        int testBorder = InputHelper.getIntegerInput("Test: ", 0 ,10);
        System.out.println(testBorder + " erfolgreich");

    }

}
