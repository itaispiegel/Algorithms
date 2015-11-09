package design.patterns;

/**
 * Singleton pattern is one of the simplest design patterns in Java. This type of design pattern comes under creational pattern as this pattern
 * provides one of the best ways to create an object.

 This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
 This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 */
public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
