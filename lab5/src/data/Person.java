package data;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Location location; //Поле не может быть null

    public Person(){}
    public Person(String name, Long weight, Color eyeColor, Location location){
        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.location = location;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
    public Color getEyeColor() {
        return eyeColor;
    }

    public Location getLocation() {
        return location;
    }

    public Long getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
