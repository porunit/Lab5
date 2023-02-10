package Interfaces;

public interface ICollectionManager {
    void show();
    void add(String name);
    void update(long id);
    void removeById(long id);
    void clear();
    void save();


}
