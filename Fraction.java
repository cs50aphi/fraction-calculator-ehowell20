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

    // methods
    // returns numerator
    public int getNumerator()
    {
        return numerator;
    }
    // returns denominator
    public int getDenominator()
    {
        return denominator;
    }
    // returns string form of fraction
    public String toString()
    {
        if (denominator == 1)
        {
            return Integer.toString(numerator);
        }
        else
        {
            String num = Integer.toString(numerator);
            String den = Integer.toString(denominator);
            return num + "/" + den;
        }
    }
    // returns result of numerator / denominator
    public double toDouble()
    {
        return numerator / denominator;
    }
    // returns the sum of the fractions
    public Fraction add(Fraction other)
    {
        int newDen = 0;
        int newNum = 0;
        // if denominators are the same, just add numerators
        if (other.getDenominator() == denominator)
        {
            newNum = other.getNumerator() + numerator;
            return new Fraction(newNum, denominator);
        }
        // if not, multiply other num and den, num and other den
        else
        {
            // add multiplied numbers and set as new numerator
            newNum = (other.getNumerator() * denominator) + (numerator * other.getDenominator());
            // denominator is other den * den 2
            newDen = other.getDenominator() * denominator;
            return new Fraction(newNum, newDen);
        }
    }
    // returns difference of the fractions (other - fraction)
    public Fraction subtract(Fraction other)
    {
        int newDen = 0;
        int newNum = 0;
        // if denominators are the same, just subtract numerators
        if (other.getDenominator() == denominator)
        {
            newNum = numerator - other.getNumerator();
            return new Fraction(newNum, denominator);
        }
        // if not, multiply other num and den, num and other den
        else
        {
            // subtract multiplied numbers and set as new numerator
            newNum = (numerator * other.getDenominator()) - (other.getNumerator() * denominator);
            // denominator is other den * den 2
            newDen = other.getDenominator() * denominator;
            return new Fraction(newNum, newDen);
        }
    }
    // returns product of the fractions
    public Fraction multiply(Fraction other)
    {
        // multiply numerators
        int newNum = other.getNumerator() * numerator;
        // multiply denominators
        int newDen = other.getDenominator() * denominator;
        // return product
        return new Fraction(newNum, newDen);
    }
    // returns quotient of two fractions (other / fraction)
    public Fraction divide(Fraction other)
    {
        // illegal exception if dividing by 0
        if (denominator == 0)
        {
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        // reciprocal of fraction
        Fraction reciprocal = new Fraction(denominator, numerator);
        // fraction other multiplied by reciprocal of fraction
        return other.multiply(reciprocal);
    }
    // checks if fractions are equal
    public boolean equals(Object other)
    {
        // if object other is a fraction, cast to Fraction
        if (other instanceof Fraction)
        {
            Fraction test = (Fraction)other;
            // create usable fraction equal to one being tested (not fraction other)
            Fraction frac = new Fraction(numerator, denominator);
            // if the difference between the two is 0, fractions are equal
            if (frac.subtract(test).toDouble() == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        // if object other is not a fraction, they are not equal
        else
        {
            return false;
        }
        
    }
    // converts the fraction to lowest terms
    public void toLowestTerms()
    {
        // use gcd() to find gcd of numerator and denominator
        int gcd = gcd(numerator, denominator);
        // divide both numerator and denominator by gcd
        // set numerator and denominator equal to divided values
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }
    // determinds greatest common divisor between two ints
    public static int gcd(int num, int den)
    {
        int remainder = 0;
        // while num and den are not 0
        while (num != 0 && den != 0)
        {
            // find remainder of num divided by den
            remainder = num % den;
            // set num as den
            num = den;
            // set den to remainder
            den = remainder;
        }
        // num is gcd
        return num;
    }
}