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
        setName(name);
        setWeight(weight);
        setEyeColor(eyeColor);
        setLocation(location);
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setLocation(Location location) {
       if(location !=null) this.location = location;
       else throw new WrongDataTypeException();
    }

    public void setName(String name) {
       if(name != null && !name.equals("")) this.name = name;
       else throw new WrongDataTypeException();
    }

    public void setWeight(Long weight) {
        final var minWeight = 0;
        if(weight> minWeight)
            this.weight = weight;
        else this.weight = minWeight + 1L;
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
