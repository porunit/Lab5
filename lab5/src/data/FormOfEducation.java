package data;

public enum FormOfEducation {
    DISTANCE_EDUCATION("D"),
    FULL_TIME_EDUCATION("F"),
    EVENING_CLASSES("E");

    private String firstLetter;
    FormOfEducation(String firstLetter) {
        this.firstLetter = firstLetter;
    }
    public String getFirstLetter() {
        return firstLetter;
    }
}
