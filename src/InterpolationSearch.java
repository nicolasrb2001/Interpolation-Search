import java.util.ArrayList;
import java.util.Collections;

public class InterpolationSearch {

    public static void sort_and_set_arrays(ArrayList<String> array, int[] x) {
        ArrayList<String> strings = new ArrayList();

        int y;
        for(y = 0; y < array.size(); ++y) {
            strings.add("");
            strings.set(y, array.get(y));
        }

        Collections.sort(array);

        for(y = 0; y < array.size(); ++y) {
            for(int a = 0; a < array.size(); ++a) {
                if ((array.get(y)).equals(strings.get(a))) {
                    x[y] = a;
                }
            }
        }

    }

    public static int interpolation_search(ArrayList<String> array, String item) {
        int[] x = new int[array.size()];
        sort_and_set_arrays(array, x);
        int low = 0;
        int high = array.size() - 1;

        while(!(array.get(high)).equals(array.get(low)) & item.compareTo(array.get(low)) > 0 & item.compareTo(array.get(high)) < 0) {
            int mid = low + item.compareTo(array.get(low)) * (high - low) / (array.get(high)).compareTo(array.get(low));
            if (item.compareTo(array.get(mid)) > 0) {
                low = mid + 1;
            } else {
                if (item.compareTo(array.get(mid)) <= 0) {
                    return x[mid];
                }

                high = mid - 1;
            }
        }

        if (item.equals(array.get(low))) {
            return x[low];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> testList = new ArrayList();
        testList.add("Hello");
        testList.add("World");
        testList.add("Are");
        testList.add("You");
        testList.add("How");
        int result = interpolation_search(testList, "How");
        System.out.println("Result = " + result);
    }
}