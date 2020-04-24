import java.lang.Math;

public class Fraction
{
    // instance variables
    private int numerator;
    private int denominator;

    // constructors
    public double Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        int frac = 0;
        // test if denominator is 0
        try
        {
            frac = numerator / denominator;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Denominator cannot be 0.");
        }
        // if denominator is negative
        if (denominator < 0)
        {
            // if numerator is also negative, cancel negatives
            if (numerator < 0)
            {
                return (Math.abs(numerator)) / (Math.abs(denominator));
            }
            // if numerator is positive, move negative sign to numerator
            else
            {
                return (-1 * numerator) / (Math.abs(denominator));
            }
        }
        // if no negatives, return fraction
        else
        {
            return numerator / denominator;
        }
    }
    // fraction with only numerator has denominator of 1
    public double Fraction(int numerator)
    {
        this.numerator = numerator;
        denominator = 1;
        return numerator / denominator;
    }
    // fraction with no numerator or denominator equals 0 (0/1)
    public double Fraction()
    {
        numerator = 0;
        denominator = 1;
        return numerator / denominator;
    }
}