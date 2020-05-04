import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to the Fraction Calculator!");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b where a and b are both integers.");
        String op = getOperation(kb);
        if (op.equals("Q") || op.equals("q"))
        {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        Fraction frac1 = getFraction(kb);
        Fraction frac2 = getFraction(kb);
        // perform specified operation
        Fraction result;
        boolean equals;
        switch (op)
        {
            case "+":
                // add
                result = frac1.add(frac2);
                // print result
                System.out.println(frac1 + " " + op + " " + frac2 + " is " + result);
                break;
            case "-":
                // subtract
                result = frac1.subtract(frac2);
                // print result
                System.out.println(frac1 + op + frac2 + "is" + result);
                break;
            case "*":
                // multiply
                result = frac1.multiply(frac2);
                // print result
                System.out.println(frac1 + op + frac2 + "is" + result);
                break;
            case "/":
                // divide
                result = frac1.divide(frac2);
                // print result
                System.out.println(frac1 + op + frac2 + "is" + result);
                break;
            case "=":
                // compare
                equals = frac1.equals(frac2);
                // print result
                System.out.println(frac1 + op + frac2 + "is" + equals);
        }
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
        // check for "-" in string
        int neg = fraction.indexOf("-");
        // if neg sign is in fraction
        if (neg != -1)
        {
            // if first character, remove it
            if (neg == 0)
            {
                fraction = fraction.substring(1, fraction.length());
            }
            // if the negative sign is not the first character, invalid fraction
            else
            {
                return false;
            }
        }
        // check for "/" in string
        int div = fraction.indexOf("/");
        // if no "/", check if everything in string is a number
        if (div == -1)
        {
            try
            {
                int frac = Integer.parseInt(fraction);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            return true;
        }
        // is there is, make substrings for numerator and denominator
        else
        {
            String num = fraction.substring(0, div);
            String den = fraction.substring(div + 1, fraction.length());
            // substrings should be non empty
            if (num.isEmpty() || den.isEmpty())
            {
                return false;
            }
            // substrings should be only numbers
            try
            {
                // try convert string to int
                int numer = Integer.parseInt(num);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            int denom = 1;
            try
            {
                // try convert string to int
                denom = Integer.parseInt(den);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            // denominator substring cannot be 0
            if (denom == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
    // asks user for valid fraction
    public static Fraction getFraction(Scanner kb)
    {
        boolean valid = false;
        // do until given fraction is valid
        do
        {
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String fraction = kb.nextLine();
            // valid fraction, return fraction
            if (validFraction(fraction))
            {
                valid = true;
                // check for "/" in string
                int div = fraction.indexOf("/");
                // if no "/", enter fraction as numerator
                if (div == -1)
                {
                    return new Fraction(Integer.parseInt(fraction));
                }
                // if "/", split numerator and denominator and enter into fraction
                else
                {
                    int num = Integer.parseInt(fraction.substring(0, div));
                    int den = Integer.parseInt(fraction.substring(div + 1, fraction.length()));
                    return new Fraction(num, den);
                }
            }
        }
        while (!valid);
        return new Fraction();
    }
}