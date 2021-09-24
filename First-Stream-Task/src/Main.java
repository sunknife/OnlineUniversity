import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,3,2,0,4,-5};
        IntStream stream = IntStream.of(array);
        //System.out.println(average(stream));
        //System.out.println(minElement(array));
        //System.out.println(equalsZeroCount(array));
        //System.out.println(greaterThenZeroCount(array));
        System.out.println(Arrays.toString(arrayMultipliedByNumber(stream,3)));
    }

    public static double average(IntStream stream) {
        return stream.average().getAsDouble();
    }

    public static String minElement(int[] array) {
        IntStream stream = IntStream.of(array);
        int minIndex = IntStream.range(0,array.length).reduce((a,b)->array[a] > array[b] ? b : a).getAsInt();
        return "Minimal value = " + stream.min().getAsInt() + " at index " + minIndex;
    }

    public static long equalsZeroCount(int[] array) {
        return IntStream.range(0, array.length -1).filter(i -> array[i] == 0).count();
    }

    public static long greaterThenZeroCount(int[] array) {
        return IntStream.range(0, array.length - 1).filter(i -> array[i] > 0).count();
    }

    public static int[] arrayMultipliedByNumber(IntStream stream, int number) {
        return stream.map(i -> i * number).toArray();
    }
}
