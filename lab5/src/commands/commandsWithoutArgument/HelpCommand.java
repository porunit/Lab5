package commands.commandsWithoutArgument;

import Interfaces.Command;
import Interfaces.CommandWithoutArgument;

public class HelpCommand implements CommandWithoutArgument, Command {

    public void execute() {
        System.out.println("""
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove id {element}: удалить значение элемента коллекции, id которого равен заданному
                print_field_descending_form_of_education : вывести значения поля formOfEducation всех элементов в порядке убывания
                print_descending : вывести элементы коллекции в порядке убывания
                filter_by_semester_enum semesterEnum : вывести элементы, значение поля semesterEnum которых равно заданному
                insert_at index {element} : добавить новый элемент в заданную позицию
                add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                save : сохранить коллекцию в файл
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                help : вывести справку по доступным командам
                exit : завершить программу (без сохранения в файл)
                clear : очистить коллекцию
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.""");
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам";
    }
}
