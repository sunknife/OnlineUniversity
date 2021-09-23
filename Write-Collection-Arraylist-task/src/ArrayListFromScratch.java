import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class ArrayListFromScratch<E> extends AbstractList<E>  {
    private E[] values;
    private int size;
    private int capacity;

    public ArrayListFromScratch() {
        capacity = 10;
        values = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E e) {
        try {
            if (size == capacity) {
                E[] temp = values;
                capacity = (capacity*3)/2 + 1;
                values = (E[])new Object[capacity];
                System.arraycopy(temp, 0, values, 0, temp.length);
            }
            values[size] = e;
            size++;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }


    @Override
    public E remove(int index) {
        E[] temp = values;
        try {

            values = (E[])new Object[capacity];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index+1, values, index, size - index -1);
            size--;

        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return temp[index];
    }

    public void trimToSize() {
        E[] temp = values;
        try {
            values = (E[])new Object[size];
            System.arraycopy(temp, 0, values, 0, size);
            capacity = values.length;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }

    }
}
