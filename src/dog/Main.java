package dog;

public class Main {
    public static void main(String[] args) {
        Lab rover = new Lab("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println("Is rover equal to rover2 " + rover.equals(rover2)); // false
        System.out.println("Is rover2 equal to rover " + rover2.equals(rover)); // true

        // lab is instance of dog therefore true
        // but dog is not instance of lab
        // non-reflexive
        // now true in both scenarios because subclass over ride of equals is hashed out
        // mark equals and hashcode in parent class as final

    }
}
