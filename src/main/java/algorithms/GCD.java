package algorithms;


public class GCD {

    /**
     * <p>An efficient method for computing the greatest common divisor (GCD) of two numbers,
     * the largest number that divides both of them without leaving a remainder.</p>
     * <p>
     * gcd(a, b) = gcd(b % a, a)
     * <br/>NOTE: if(a < b) -> a % b = a - Meaning that the order of the parameters has no significance.
     */
    public int gcd(int a, int b) {
        int mod = b % a;

        if (mod == 0) {
            return a;
        }

        return gcd(mod, a);
    }

    /**
     * An efficient method for computing the least common multiple (lcm) of two numbers, the lowest integer
     * that is a multiple of both given integers.
     */
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
