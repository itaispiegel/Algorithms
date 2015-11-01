package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Itai on 01-Nov-15.
 */
public class TowersOfHanoiTest extends TowersOfHanoi {

    @Test
    public void testSolve() throws Exception {
        solve(4, "A", "B", "C");
    }
}