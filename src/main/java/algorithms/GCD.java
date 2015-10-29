package algorithms;

/**
 * <p>An efficient method for computing the greatest common divisor (GCD) of two numbers,
 * the largest number that divides both of them without leaving a remainder.</p>
 * <p>
 * gcd(a, b) = gcd(b % a, a)
 * <br/>NOTE: if(a < b) -> a % b = a - Meaning that the order of the parameters has no significance.
 */
public class GCD {

    public int gcd(int a, int b) {
        int mod = b % a;

        if (mod == 0) {
            return a;
        }

        return gcd(mod, a);
    }

}
