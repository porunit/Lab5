package data;

import exceptions.WrongDataTypeException;
import org.jetbrains.annotations.Nullable;

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
       if(name!=null) this.name = name;
       else throw new WrongDataTypeException();
    }

    public void setWeight(Long weight) {
        if(weight>0)
        this.weight = weight;
        else this.weight = Long.valueOf(1);
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
