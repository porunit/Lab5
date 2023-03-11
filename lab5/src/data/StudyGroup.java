package data;

import exceptions.WrongDataTypeException;

import java.time.format.DateTimeFormatter;


public class StudyGroup {
    private long id = 1;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDateWithoutFormat = java.time.ZonedDateTime.now();
    private String creationDate = creationDateWithoutFormat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private Integer studentsCount;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private Person groupAdmin;

    public StudyGroup() {
    }

    public StudyGroup(long id, String name, Coordinates coordinates, Integer studentsCount,
                      FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        if (id <= 0)
            throw new WrongDataTypeException();
        this.id = id;
        if (name == null || name.isEmpty())
            throw new WrongDataTypeException();
        this.name = name;
        if (coordinates == null)
            throw new WrongDataTypeException();
        this.coordinates = coordinates;
        this.creationDateWithoutFormat = java.time.ZonedDateTime.now();
        this.formOfEducation = formOfEducation;
        if (studentsCount != null && studentsCount < 0) this.studentsCount = 1;
        else this.studentsCount = studentsCount;
        if (semesterEnum == null)
            throw new WrongDataTypeException();
        else this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) throw new WrongDataTypeException();
        else this.id = id;
    }

    public String toString() {

        if (groupAdmin != null) return "- id: " + id + "\n" +
                "  name: " + name + "\n" +
                "  coordinates:\n" +
                "    x: " + coordinates.getX() + "f\n" +
                "    \"y\": " + coordinates.getY() + "\n" +
                "  creationDate: " + creationDate + "\n" +
                "  studentsCount: " + studentsCount + "\n" +
                "  formOfEducation: " + formOfEducation + "\n" +
                "  semesterEnum: " + semesterEnum + "\n" +
                "  groupAdmin:\n" +
                "    name: " + groupAdmin.getName() + "\n" +
                "    weight: " + groupAdmin.getWeight() + "\n" +
                "    eyeColor: " + groupAdmin.getEyeColor() + "\n" +
                "    location:\n" +
                "      x: " + groupAdmin.getLocation().getX() + "f\n" +
                "      \"y\": " + groupAdmin.getLocation().getY() + "\n" +
                "      z: " + groupAdmin.getLocation().getZ();

        else return "- id: " + id + "\n" +
                "  name: " + name + "\n" +
                "  coordinates:\n" +
                "    x: " + coordinates.getX() + "f\n" +
                "    \"y\": " + coordinates.getY() + "\n" +
                "  creationDate: " + creationDate + "\n" +
                "  studentsCount: " + studentsCount + "\n" +
                "  formOfEducation: " + formOfEducation + "\n" +
                "  semesterEnum: " + semesterEnum + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) this.name = name;
        else throw new WrongDataTypeException();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String formattedDateTime) {
        if (formattedDateTime != null) this.creationDate = formattedDateTime;
        else throw new WrongDataTypeException();
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemester() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        if (semesterEnum != null) this.semesterEnum = semesterEnum;
        else throw new WrongDataTypeException();
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

}

