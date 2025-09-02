import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        Integer [] array = {2,4,6,8};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        mystery1(list);
    }
    public static void mystery1(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i += 2) {
            int element = list.get(i);
            list.remove(i);
            list.add(element);
        }
        System.out.println(list);
    }
}
