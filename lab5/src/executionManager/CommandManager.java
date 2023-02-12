package executionManager;

import data.Semester;

class CommandManager {
    protected CollectionManager collectionManager;
    public CommandManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

     public void idContainsCommands(String idString, String mode){
        long id = 0;
        boolean flag = false;
        try{
            id = Long.parseLong(idString);
        } catch (NumberFormatException e){
            System.out.println("id must be number");
            flag = true;
        }
        if (collectionManager.groupStack.empty() && !flag) System.out.println("Collection is empty");
        else if (!collectionManager.uniqueId.contains(id) && !flag) {
            System.out.println("id doesn't exists");
        }else if(mode.equals("update")) collectionManager.update(id);
        else if(mode.equals("remove"))collectionManager.removeById(id);
    }

    public void add(String name) {
        if (!name.trim().equals("")) {
            collectionManager.add(name);
        }
    }

    public void show() {
        if(collectionManager.groupStack.empty()) System.out.println("Stack is empty");
        else collectionManager.show();
    }
    public void printFieldDescendingFormOfEducation(){
        if(collectionManager.groupStack.empty()) System.out.println("Collection is empty");
        else collectionManager.printFieldDescendingFormOfEducation();
    }

    public void printDescending(){
        if(collectionManager.groupStack.empty()) System.out.println("Collection is empty");
        else collectionManager.printDescending();
    }

    public void filterBySemesterEnum(String semesterString){
        try{
            Semester semester = Semester.valueOf(semesterString);
            collectionManager.filterBySemesterEnum(semester);
        }catch (IllegalArgumentException e){
            System.out.println("No such semester");
        }
    }
    public void insertAt(String index){
        try{
            int ind = Integer.parseInt(index);
            if(ind>collectionManager.groupStack.size() && collectionManager.groupStack.empty() ||
                    ind>collectionManager.groupStack.size()+1 && !collectionManager.groupStack.empty())
                System.out.println("index bigger than must be");
            else collectionManager.insertAt(ind);
        } catch (NumberFormatException | NullPointerException | StackOverflowError e) {
        System.out.println("Wrong index format");
        }
    }
    public void load(){
        collectionManager.load();
    }
    public void addIfMin(){
        collectionManager.addIfMin();
    }
    public void save(){
        collectionManager.save();
    }
    public void info(){
        System.out.println("type: Stack\n" +
                "creation's date: "+ java.time.ZonedDateTime.now()+"\n" +
                "size: "+ collectionManager.groupStack.size());
    }
    public void help(){
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                insert_at index {element} : добавить новый элемент в заданную позицию
                remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)
                add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                filter_by_semester_enum semesterEnum : вывести элементы, значение поля semesterEnum которых равно заданному
                print_descending : вывести элементы коллекции в порядке убывания
                print_field_descending_form_of_education : вывести значения поля formOfEducation всех элементов в порядке убывания
                """);
    }
}

