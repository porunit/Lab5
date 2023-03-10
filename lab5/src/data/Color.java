package data;

public enum Color {
    RED("Красный"),
    BLACK("Черный"),
    YELLOW("Желтый");

    private String stringColor;
    Color(String color) {
        stringColor = color;
    }
    public String getStringColor(){
        return stringColor;
    }
}
