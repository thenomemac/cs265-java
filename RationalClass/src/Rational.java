import java.util.Comparator;

/**
 * Josiah Olson on 3/7/16.
 */

public class Rational extends Number implements Comparable {
    private long numerator;
    private long denominator;

    public Rational() throws IllegalArgumentException {
        this(0, 1);
    }

    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        this((long)numerator, (long)denominator);
    }

    public Rational(long numerator, long denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Rational cannot have a zero in the denominator.");
        }
        long gcd = gcd(numerator, denominator);
        this.numerator = ((denominator > 0) ? 1: -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    private static long gcd(long n1, long n2) {
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);
        long gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }
        gcd = ((n1 == 0) ? n2: gcd);
        return gcd;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational other) {
        long n = numerator * other.getDenominator()
                + denominator * other.getNumerator();
        long d = denominator * other.getDenominator();
        return new Rational(n, d);
    }

    public Rational subtract(Rational other) {
        long n = numerator * other.getDenominator()
                - denominator * other.getNumerator();
        long d = denominator * other.getDenominator();
        return new Rational(n, d);
    }

    public Rational multiply(Rational other) {
        long n = numerator * other.getNumerator();
        long d = denominator * other.getDenominator();
        return new Rational(n, d);
    }

    public Rational divide(Rational other) {
        long n = numerator * other.getDenominator();
        long d = denominator * other.getNumerator();
        return new Rational(n, d);
    }

    public String toString() {
        if (denominator == 1)
            return Long.toString(numerator);
        else
            return numerator + "/" + denominator;
    }

    public boolean equals(Object otherObj) {
        if ((this.subtract((Rational)otherObj)).getNumerator() == 0)
            return true;
        else
            return false;
    }

    public int intValue() {
        return (int)doubleValue();
    }

    public long longValue() {
        return (long)doubleValue();
    }

    public float floatValue() {
        return (float)doubleValue();
    }

    public double doubleValue() {
        return 1.0 * numerator / denominator;
    }

    public int compareTo(Object otherObj) {
        Rational diff = this.subtract((Rational)otherObj);
        if (diff.getNumerator() > 0)
            return 1;
        else if (diff.getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}
