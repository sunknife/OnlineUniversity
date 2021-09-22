import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = {4,5,-6,4,5,3,4,2,4,5,7};
        for (Integer element: array) {
            list.add(element);
        }
        System.out.println(dublicateCount(list));
        NewArrayList<Integer> arrayList= new NewArrayList();
        arrayList.add(4);
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);


    }

    public static String dublicateCount(ArrayList<Integer> list) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer element: list) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            }
            else {
                Integer newValue = map.get(element);
                newValue++;
                map.replace(element,newValue);
            }
        }
        return map.toString();
    }

}
