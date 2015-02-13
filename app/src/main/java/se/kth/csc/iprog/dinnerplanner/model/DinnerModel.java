package se.kth.csc.iprog.dinnerplanner.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class DinnerModel extends Observable implements IDinnerModel  {

    Set<Dish> dishes = new HashSet<Dish>();
    Set<Dish> menu = new HashSet<Dish>();
    int guests = 2;

    public DinnerModel(){

        //Adding some example data, you can add more
        Dish dish1 = new Dish("French toast",Dish.STARTER, R.drawable.toast,"In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
        Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
        Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
        Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
        Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
        Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
        dish1.addIngredient(dish1ing1);
        dish1.addIngredient(dish1ing2);
        dish1.addIngredient(dish1ing3);
        dish1.addIngredient(dish1ing4);
        dish1.addIngredient(dish1ing5);
        dishes.add(dish1);

        Dish dish2 = new Dish("Meat balls",Dish.MAIN,R.drawable.meatballs,"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
        Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
        Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
        Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
        Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
        Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
        Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
        Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes",0.6,"g",3);
        Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
        Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
        Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese",5,"g",8);
        Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs",115,"g",4);
        dish2.addIngredient(dish2ing1);
        dish2.addIngredient(dish2ing2);
        dish2.addIngredient(dish2ing3);
        dish2.addIngredient(dish2ing4);
        dish2.addIngredient(dish2ing5);
        dish2.addIngredient(dish2ing6);
        dish2.addIngredient(dish2ing7);
        dish2.addIngredient(dish2ing8);
        dish2.addIngredient(dish2ing9);
        dish2.addIngredient(dish2ing10);
        dish2.addIngredient(dish2ing11);
        dishes.add(dish2);

        Dish starter1 = new Dish("Onion Soup", Dish.STARTER, R.drawable.onion, "The onion soup is a very nice dish you can try here.");
        Ingredient start1ing1 = new Ingredient("Onions", 100, "pcs",20);
        starter1.addIngredient(start1ing1);
        Ingredient start1ing2 = new Ingredient("Pepper", 10, "dl",21);
        starter1.addIngredient(start1ing2);
        Ingredient start1ing3 = new Ingredient("Potatoes", 100, "pcs",3);
        starter1.addIngredient(start1ing3);
        Ingredient start1ing4 = new Ingredient("Cheese", 100, "g",2);
        starter1.addIngredient(start1ing4);
        dishes.add(starter1);

        Dish dessert1 = new Dish("Ice Cream", Dish.DESERT, R.drawable.icecream, "Your own recipe for vanilla ice cream");
        Ingredient dess1ing1 = new Ingredient("Cream", 100, "g",20);
        dessert1.addIngredient(dess1ing1);
        Ingredient dess1ing2 = new Ingredient("Sugar", 10, "g",21);
        dessert1.addIngredient(dess1ing2);
        Ingredient dess1ing3 = new Ingredient("Vanilla", 100, "ml",3);
        dessert1.addIngredient(dess1ing3);
        Ingredient dess1ing4 = new Ingredient("Cones", 30, "pcs",2);
        dessert1.addIngredient(dess1ing4);
        dishes.add(dessert1);
    }

    public int getNumberOfGuests() {
        return guests;
    }
    public void setNumberOfGuests(int numberOfGuests) {
        this.guests = numberOfGuests;
        setChanged();
        notifyObservers();
    }

    /**
     * Returns the dish that is on the menu for selected type (1 = starter, 2 = main, 3 = desert).
     */
    public Dish getSelectedDish(int type) {
        for(Dish d : menu) {
            if(d.type == type) {
                return d;
            }
        }
        return null;
    }

    /**
     * Returns all the dishes on the menu.
     */
    public Set<Dish> getFullMenu() {
        return menu;
    }

    /**
     * Returns all ingredients for all the dishes on the menu.
     */
    public Set<Ingredient> getAllIngredients() {
        Set<Ingredient> ingredients = new HashSet<Ingredient>();
        for(Dish d : menu) {
            ingredients.addAll(d.getIngredients());
        }
        return ingredients;
    }
    public String getAllIngredientsAsString() {
        String ingredientList = "";
        for (Ingredient i : getAllIngredients()) {
            ingredientList += i.getName() + " " + i.getQuantity() + " " + i.getUnit() + "\n";
        }
        return ingredientList;
    }

    /**
     * Returns the total price of the menu (all the ingredients multiplied by number of guests).
     */
    public float getTotalMenuPrice() {
        float total = 0;
        for(Ingredient i : getAllIngredients()) {
            total += i.price;
        }
        return guests*total;
    }

    /**
     * Adds the passed dish to the menu. If the dish of that type already exists on the menu
     * it is removed from the menu and the new one added.
     */
    public void addDishToMenu(Dish dish) {
        ArrayList<Dish> dishesToRemove = new ArrayList<Dish>();
        for(Dish d : menu) {
            if(d.type == dish.type)
                dishesToRemove.add(d);
        }
        for(Dish d : dishesToRemove) {
            menu.remove(d);
        }
        menu.add(dish);
        setChanged();
        notifyObservers();
    }

    /**
     * Remove dish from menu
     */
    public void removeDishFromMenu(Dish dish) {
        menu.remove(dish);
        setChanged();
        notifyObservers();
    }

    public boolean inMenu(Dish dish) {
        return menu.contains(dish);
    }

    /**
     * Get dish by name
     */
    public Dish getDishByName(String name) {
        for (Dish d : dishes) {
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }

    /**
     * The constructor of the overall model. Set the default values here
     */


    /**
     * Returns the set of dishes.
     */
    public Set<Dish> getDishes(){
        return dishes;
    }

    /**
     * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
     */
    public Set<Dish> getDishesOfType(int type){
        Set<Dish> dishesType = new HashSet<Dish>();
        for(Dish d : dishes){
            if(d.getType() == type){
                dishesType.add(d);
            }
        }
        return dishesType;
    }

    /**
     * Returns the set of dishes of specific type, that contain filter in their name
     * or name of any ingredient.
     */
    public Set<Dish> filterDishesOfType(int type, String filter){
        Set<Dish> result = new HashSet<Dish>();
        for(Dish d : dishes){
            if(d.getType() == type && d.contains(filter)){
                result.add(d);
            }
        }
        return result;
    }



}
