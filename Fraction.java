import java.lang.Math;

public class Fraction
{
    // instance variables
    private int numerator;
    private int denominator;

    // constructors
    public Fraction(int numerator, int denominator)
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
                numerator = Math.abs(numerator);
                denominator = Math.abs(denominator);
            }
            // if numerator is positive, move negative sign to numerator
            else
            {
                numerator = -1 * numerator;
                denominator = Math.abs(denominator);
            }
        }
    }
    // fraction with only numerator has denominator of 1
    public Fraction(int numerator)
    {
        this(numerator, 1);
    }
    // fraction with no numerator or denominator equals 0 (0/1)
    public Fraction()
    {
        this(0, 1);
    }
}