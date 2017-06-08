package recrutmenttasks;


public interface List <T extends Comparable<T>>  {

    void addElement(T element);
    T get(int index);
    int size();
    void sort();
}
