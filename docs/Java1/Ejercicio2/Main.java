package Java1.Ejercicio2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        String[] data = {"H", "S", "I", "V", "E", "W", "M", "P", "L", "C", "N", "K",
                "O", "A", "Q", "R", "J", "D", "G", "T", "U", "X", "B", "Y", "Z", "F"};
        System.out.println("data = " + Arrays.toString(data));

        SortFunction ascendingSort = dataArray -> {
            Arrays.sort(dataArray);
            return dataArray;
        };

        SortFunction descendingSort = dataArray -> {
            Arrays.sort(dataArray, Collections.reverseOrder());
            return dataArray;
        };

        SortFunction randomSort = dataArray -> {
            List<String> dataList = Arrays.asList(dataArray);
            Collections.shuffle(dataList);
            return dataList.toArray(new String[0]);
        };

        DataSorter dataSorter = new DataSorterDesc(descendingSort);
        dataSorter.sort(data);
        System.out.println("data (desc) = " + Arrays.toString(data));

        dataSorter = new DataSorterAsc(ascendingSort);
        dataSorter.sort(data);
        System.out.println("data (asc) = " + Arrays.toString(data));

        dataSorter = new DataSorterAsc(randomSort);
        dataSorter.sort(data);
        System.out.println("data (random) = " + Arrays.toString(data));
    }
}
