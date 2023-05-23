package Java1.Ejercicio1;

import java.util.List;

public interface DataOperations {
    void print(int[] data);
    int[] filterPairs(int[] data);
    List<Integer> sortDescending(int[] data);
    void multiplyByTenAndPrint(int[] data);
    int sum(int[] data);
}