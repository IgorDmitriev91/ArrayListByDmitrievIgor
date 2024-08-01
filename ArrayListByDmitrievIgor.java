
import java.util.Collection;

public class ArrayListByDmitrievIgor<T> {
    private int INIT_SIZE = 16;
    private Object[] array;
    private int size = 0;
    private static final Object[] EMPTY_ARRAY = {};

    public ArrayListByDmitrievIgor() {
        array = new Object[INIT_SIZE];
    }

    public ArrayListByDmitrievIgor(int x) {
        if (x > 0) {
            array = new Object[x];
        } else if (x == 0) {
            array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void add(int index, T element) {
        if (size == array.length - 1)
            resize();

        array[size++] = element;
        System.arraycopy(array, index,
                array, index + 1,
                size - index);
        array[index] = element;
        size = size++;
    }

    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        if (a.length == 0) {
            return false;
        } else {
            resize(a.length);
            System.arraycopy(a, 0, array, size, a.length);
            size += a.length;
            return true;
        }

    }

    public void clear() {
        array = EMPTY_ARRAY;
    }


    public T get(int index) {
        if (index < size - 1) {
            return (T) array[index];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        array[size] = null;
        size--;
    }

    public void remove(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (o == array[i]) {
                index = i;
            }
        }
        if (index >= 0) {
            for (int i = index; i < size; i++)
                array[i] = array[i + 1];
            array[size] = null;
            size--;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void sort() {
        if (array[0] instanceof Integer) {

QuickSort.quickSort(array,0,size);
        }
    }


    private void resize() {
        int newLength = (int) (array.length * 1.5 + 1);
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}