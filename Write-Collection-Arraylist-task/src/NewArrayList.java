import java.util.ArrayList;

public class NewArrayList<T> extends ArrayList<T> {

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean add(T o) {
        return super.add(o);
    }
}
