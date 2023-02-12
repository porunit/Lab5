package data;

import exceptions.WrongDataTypeException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class StudyGroup {
    private long id;
    private String name;
    private Coordinates coordinates;
    @NotNull private java.time.ZonedDateTime creationDate;
    @Nullable private Integer studentsCount;
    @Nullable private FormOfEducation formOfEducation;
    @NotNull private Semester semesterEnum;
    @Nullable private Person groupAdmin;

    public StudyGroup(){}
    public StudyGroup(long id, String name, Coordinates coordinates, Integer studentsCount,
                      FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin){
            if (id <= 0)
                throw new WrongDataTypeException("Wrong data type");
            this.id = id;
            if (name == null || name.isEmpty())
                throw new WrongDataTypeException("Wrong data type");
            this.name = name;
            if (coordinates == null)
                throw new WrongDataTypeException("Wrong data type");
            this.coordinates = coordinates;
            creationDate = java.time.ZonedDateTime.now();
            this.formOfEducation = formOfEducation;
            if (studentsCount < 0)
                this.studentsCount = 0;
            else this.studentsCount = studentsCount;
            if(semesterEnum == null)
                throw new WrongDataTypeException("Wrong data type");
            else this.semesterEnum = semesterEnum;
            this.groupAdmin = groupAdmin;
        }

    public long getId(){
        return id;
    }

    public String toString(){
        return "- id: "+id+"\n" +
                "  name: "+name+"\n" +
                "  coordinates:\n" +
                "    x: "+coordinates.getX()+"f\n" +
                "    y: "+coordinates.getY()+"\n" +
                "  creationDate: "+creationDate+"\n" +
                "  studentsCount: "+studentsCount+"\n" +
                "  formOfEducation: "+formOfEducation+"\n" +
                "  semesterEnum: "+semesterEnum+"\n" +
                "  groupAdmin:\n" +
                "    name: "+groupAdmin.getName()+"\n" +
                "    weight: "+groupAdmin.getWeight()+"\n" +
                "    eyeColor: "+groupAdmin.getEyeColor()+"\n" +
                "    location:\n" +
                "      x: "+groupAdmin.getLocation().getX()+"\n" +
                "      y: "+groupAdmin.getLocation().getY()+"\n" +
                "      z: "+groupAdmin.getLocation().getZ();
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
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
        this.semesterEnum = semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

}

