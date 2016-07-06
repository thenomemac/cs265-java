import javax.sound.midi.SysexMessage;

public class Main {
    public static void main(String[] args) {
        Rational r1 = new Rational(4, 2);
        Rational r2 = new Rational(2, 3);
        Rational r3 = new Rational(8, 12);
        Rational r4 = new Rational(8, -12);
        Rational r5 = new Rational(1000, 999);

        System.out.println(r1.add(r2));
        System.out.println(r1.subtract(r2));
        System.out.println(r1.multiply(r2));
        System.out.println(r1.divide(r2));
        System.out.println(r2.doubleValue());
        System.out.println(r4);
        System.out.println(r2.equals(r3));
        System.out.println(r2 == r3);
        System.out.println(r4.compareTo(r3));
        System.out.println((r5.doubleValue() + 1 ) * 1);
        System.out.println(r1.subtract(r1));
        System.out.println(r4.add(r3));
        try {
            System.out.println(new Rational(1, 0));
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
