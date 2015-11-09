package design.patterns;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Itai on 07-Nov-15.
 */
public class SingletonTest {

    @Test
    public void testGreet() throws Exception {
        Singleton singleton = Singleton.getInstance();
        assertEquals("Hello, Itai!", singleton.greet("Itai"));
    }
}