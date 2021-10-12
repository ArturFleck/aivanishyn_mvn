package Homework_16;

import java.util.Arrays;
import java.util.Objects;

public class StringCollectionImpl implements StringCollection {
    private String[] array = new String[0];

    @Override
    public String get(int index) {
        if (array.length - 1 >= index) {
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public boolean add(String str) {
        String[] newArr = new String[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[newArr.length - 1] = str;
        this.array = newArr;
        return true;
    }

    @Override
    public boolean add(int index, String str) {
        boolean y = false;
        if (index > array.length) {
            return false;
        }
        String[] newArr = new String[array.length + 1];
        if (index == 0) {   // if our new member index equals 0, which means our first member so we put it in a head and shift old array
            newArr[0] = str;
            System.arraycopy(array, 0, newArr, 1, array.length);
        } else if (index == newArr.length)  // if new member have index bigger than length of our array than we put it in a tail
        {
            add(str);
        } else {
            int i = 0;
            for (int x = 0; x < array.length + 1; x++) {
                if (index < x) {
                    newArr[x] = array[i];
                    i++;
                } else if (index == x) {
                    newArr[x] = str;
                } else {
                    newArr[x] = array[i];
                    i++;
                }
            }
        }
        this.array = newArr;
        return true;
    }

    @Override
    public boolean delete(String str) {
        boolean y = false;
        if (contains(str)) {
            String[] newArr = new String[array.length - 1];
            int i = 0;
            for (String s : array) {
                if (!Objects.equals(array[i], str)) {
                    newArr[i] = s;
                    i++;
                }
            }
            this.array = newArr;
            y = true;
        }
        return y;
    }

    @Override
    public boolean contains(String str) {
        boolean x = false;
        for (String s : array) {
            if (Objects.equals(s, str)) {
                x = true;
                break;
            }
        }
        return x;
    }

    @Override
    public boolean clear() {
        array = new String[0];
        return true;
    }

    @Override
    public int size() {
        return this.array.length;
    }

/*    @Override
    public boolean equals(StringCollection collection) {
        if (collection == null) {
            return false;
        }
        if (collection.getClass() != this.getClass()) {
            return false;
        }
        if (!(collection instanceof StringCollectionImpl))
            return false;

        if(this == collection)
            return true;
        if(collection instanceof StringCollectionImpl){
            return this.array.equals(((StringCollectionImpl) collection).array);
        }
        return true;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringCollectionImpl)) return false;

        StringCollectionImpl that = (StringCollectionImpl) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "StringCollectionImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
