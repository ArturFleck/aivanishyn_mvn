package homework_16;

public interface StringCollection {
    String get(int index);

    boolean add(String str);

    boolean add(int index, String str);

    boolean delete(String str);

    boolean contains(String str);

    //boolean equals(StringCollection collection);
    public boolean equals(Object o);

    boolean clear();

    int size();

}
