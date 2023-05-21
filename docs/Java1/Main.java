package Java1;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("data = " + Arrays.toString(data));

        DataOperations operations = new DataOperationsImpl();

        operations.print(data);
        data = operations.filterPairs(data);
        operations.print(data);

        System.out.println("Sorted descending: " + operations.sortDescending(data));
        operations.multiplyByTenAndPrint(data);
        System.out.println("Sum: " + operations.sum(data));
    }
}

/*
 * 
 * En la clase Main, cambia la implementación de DataOperations a la nueva implementación basada en expresiones lambda y streams.
 * 
 * 
 */