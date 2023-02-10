package data;

import exceptions.WrongDataTypeException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StudyGroup {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @NotNull private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Nullable private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    @Nullable private FormOfEducation formOfEducation; //Поле может быть null
    @NotNull private Semester semesterEnum; //Поле не может быть null
    @Nullable private Person groupAdmin; //Поле может быть null

    public StudyGroup(long id, String name, Coordinates coordinates,
                      java.time.ZonedDateTime creationDate, Integer studentsCount,
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
            this.formOfEducation = formOfEducation;
            if (studentsCount <= 0)
                throw new WrongDataTypeException("Wrong data type");
            this.studentsCount = studentsCount;
            if(semesterEnum == null)
                throw new WrongDataTypeException("Wrong data type");
            else this.semesterEnum = semesterEnum;
            this.groupAdmin = groupAdmin;
        }
    

    public void setId(long id) {
        this.id = id;
    }
    public long getId(){
        return id;
    }

    public String toString(){
        return "- id: "+id+"\n" +
                "  name: "+name+"\n" +
                "  coordinates:\n" +
                "    x: "+coordinates.getX()+"\n" +
                "    y: "+coordinates.getY()+"\n" +
                "  creationDate: "+creationDate+"\n" +
                "  studentCount: "+studentsCount+"\n" +
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
}
