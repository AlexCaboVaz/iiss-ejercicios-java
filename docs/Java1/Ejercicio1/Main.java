package Java1.Ejercicio1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("data = " + Arrays.toString(data));

        DataOperations operations = new DataOperationsImpl();
        operations.print(data);
        data = operations.filterPairs(data);
        operations.print(data);

        List<Integer> sortedList = operations.sortDescending(data);
        System.out.println("Sorted Descending: " + sortedList);

        operations.multiplyByTenAndPrint(data);

        int sum = operations.sum(data);
        System.out.println("Sum: " + sum);
    }
}