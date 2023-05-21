package Java1.Ejercicio2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        String[] data = {"H", "S", "I", "V", "E", "W", "M", "P", "L", "C", "N", "K",
                "O", "A", "Q", "R", "J", "D", "G", "T", "U", "X", "B", "Y", "Z", "F"};
        System.out.println("data = " + Arrays.toString(data));

        DataSorter dataSorter = (arr) -> {
            List<String> list = Arrays.asList(arr);
            Collections.shuffle(list);
            return list.toArray(new String[0]);
        };
        dataSorter.sort(data);
        System.out.println("data (random) = " + Arrays.toString(data));

        DataSorter dataSorterAsc = (arr) -> {
            Arrays.sort(arr);
            return arr;
        };
        dataSorterAsc.sort(data);
        System.out.println("data (asc) = " + Arrays.toString(data));

        DataSorter dataSorterDesc = (arr) -> {
            Arrays.sort(arr, Collections.reverseOrder());
            return arr;
        };
        dataSorterDesc.sort(data);
        System.out.println("data (desc) = " + Arrays.toString(data));
    }

    @FunctionalInterface
    public interface DataSorter {
        String[] sort(String[] data);
    }
}
