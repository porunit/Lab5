package executionManager;

import Interfaces.ICommandManager;
import commandEnums.Mode;

public class CommandDescriptionManager implements ICommandManager {
    @Override
    public void show() {
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public void add(String name) {
        System.out.println("add {element} : добавить новый элемент в коллекцию");
    }

    @Override
    public void idContainsCommands(String idString, Mode mode) {
        if (mode == Mode.UPDATE)
            System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        else System.out.println("remove id {element}: удалить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void printFieldDescendingFormOfEducation() {
        System.out.println("print_field_descending_form_of_education : вывести значения поля formOfEducation всех элементов в порядке убывания");
    }

    @Override
    public void printDescending() {
        System.out.println("print_descending : вывести элементы коллекции в порядке убывания");
    }

    @Override
    public void filterBySemesterEnum(String semesterString) {
        System.out.println("filter_by_semester_enum semesterEnum : вывести элементы, значение поля semesterEnum которых равно заданному");
    }

    @Override
    public void insertAt(String parameter) {
        System.out.println("insert_at index {element} : добавить новый элемент в заданную позицию");
    }

    @Override
    public void addIfMin() {
        System.out.println("add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    @Override
    public void save() {
        System.out.println("save : сохранить коллекцию в файл");
    }

    @Override
    public void info() {
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public void help() {
        System.out.println("help : вывести справку по доступным командам\nexit : завершить программу (без сохранения в файл)");
    }
    public void clear(){
        System.out.println("clear : очистить коллекцию\nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }
}
