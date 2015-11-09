package design.patterns;

import java.util.Hashtable;

import static design.patterns.Prototype.*;

/**
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * This pattern involves implementing a prototype interface which tells to create a clone of the current object.
 * This pattern is used when creation of object directly is costly. For example, an object is to be created after a costly database operation.
 * We can cache the object, returns its clone on next request and update the database as and when needed thus reducing database calls.
 */
public class Prototype {


    public abstract class Shape implements Cloneable {
        private String id;
        protected String type;

        abstract void draw();

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Object clone = null;

            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            return clone;
        }
    }

    public class Rectangle extends Shape {

        public Rectangle() {
            this.type = "Rectangle";
        }

        @Override
        void draw() {
            System.out.println("Drawing Rectangle...");
        }
    }

    public class Sqaure extends Shape {

        public Sqaure() {
            this.type = "Square";
        }

        @Override
        void draw() {
            System.out.println("Drawing Square...");
        }
    }


    public class Circle extends Shape {

        public Circle() {
            this.type = "Circle";
        }

        @Override
        void draw() {
            System.out.println("Drawing Circle...");
        }
    }

    class ShapeCache {
        private Hashtable<String, Shape> shapeMap = new Hashtable<>();

        public Prototype.Shape getShape (String id) throws CloneNotSupportedException {
            Shape cachedShape = shapeMap.get(id);
            return (Shape) cachedShape.clone();
        }

        public void loadCache() {
            Shape circle = new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(), circle);

            Shape rectangle = new Rectangle();
            rectangle.setId("2");
            shapeMap.put(rectangle.getId(), rectangle);

            Shape square = new Sqaure();
            square.setId("3");
            shapeMap.put(square.getId(), square);
        }
    }

}