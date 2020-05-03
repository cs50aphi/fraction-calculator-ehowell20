import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
    }
    // asks user for valid operation
    public static String getOperation(Scanner kb)
    {
        String operation = "";
        boolean valid = false;
        do
        {
            // asks user for operation
            System.out.print("Enter an operation (+, -, *, /, =, or Q to quit): ");
            operation = kb.nextLine();
            // repromt if not +, -, *, /, =, q, or Q
            switch (operation)
            {
                case "+":
                case "-":
                case "*":
                case "/":
                case "=":
                case "q":
                case "Q":
                    // if valid operation return operation as string
                    valid = true;
                    break;
                default:
                    // if not valid, repromt
                    break;
            }
        }
        while (!valid);
        return operation;
    }
    // return true if valid fraction
    public static boolean validFraction(String fraction)
    {

    }
    // asks user for valid fraction
    public static Fraction getFraction(Scanner kb)
    {

    }
}