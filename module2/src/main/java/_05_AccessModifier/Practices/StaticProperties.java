package _05_AccessModifier.Practices;

public class StaticProperties {
    private String name;

    private String engine;

    public static int numberOfCars;

    public StaticProperties(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }
}
class TestStaticProperty {

    public static void main(String[] args) {

        StaticProperties car1 = new StaticProperties("Mazda 3","Skyactiv 3");

        System.out.println(StaticProperties.numberOfCars);

        StaticProperties car2 = new StaticProperties("Mazda 6","Skyactiv 6");

        System.out.println(StaticProperties.numberOfCars);
    }

}
