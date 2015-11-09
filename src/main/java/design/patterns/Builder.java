package design.patterns;

import java.util.LinkedList;
import java.util.List;

/**
 * Builder pattern builds a complex object using simple objects and using a step by step approach.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * A Builder class builds the final object step by step. This builder is independent of other objects.
 */
public class Builder {

    public interface Item {
        String name();
        Packing packing();
        float price();
    }

    public interface Packing {
        String pack();
    }

    public class Wrapper implements Packing {

        @Override
        public String pack() {
            return "Wrapper";
        }
    }

    public class Bottle implements Packing {

        @Override
        public String pack() {
            return "Bottle";
        }
    }

    public abstract class Burger implements Item {

        @Override
        public Packing packing() {
            return new Wrapper();
        }

        @Override
        public abstract float price();
    }

    public abstract class ColdDrink implements Item {

        @Override
        public Packing packing() {
            return new Bottle();
        }

        @Override
        public abstract float price();
    }

    public class VegBurger extends Burger {

        @Override
        public String name() {
            return "Veg Burger";
        }

        @Override
        public float price() {
            return 25.0f;
        }
    }

    public class ChickenBurger extends Burger {

        @Override
        public String name() {
            return "Chicken Burger";
        }

        @Override
        public float price() {
            return 50.5f;
        }
    }

    public class Coke extends ColdDrink {

        @Override
        public String name() {
            return "Coke";
        }

        @Override
        public float price() {
            return 30.0f;
        }
    }

    public class Pepsi extends ColdDrink {

        @Override
        public String name() {
            return "Pepsi";
        }

        @Override
        public float price() {
            return 35.0f;
        }
    }

    public class Meal {

        private List<Item> items = new LinkedList<>();

        public void addItem(Item item) {
            items.add(item);
        }

        public float getCost() {
            float cost = 0;

            for(Item item : items) {
                cost += item.price();
            }

            return cost;
        }

    }

    public class MealBuilder {

        public Meal prepareVegMeal() {
            Meal meal = new Meal();
            meal.addItem(new VegBurger());
            meal.addItem(new Coke());

            return meal;
        }

        public Meal prepareNoneVegMeal () {
            Meal meal = new Meal();
            meal.addItem(new ChickenBurger());
            meal.addItem(new Pepsi());

            return meal;
        }
    }
}
