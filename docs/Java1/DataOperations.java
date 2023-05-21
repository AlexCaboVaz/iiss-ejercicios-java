package Java1;

import java.util.List;

public interface DataOperations {
    void print(int[] data);
    int[] filterPairs(int[] data);
    List<Integer> sortDescending(int[] data);
    void multiplyByTenAndPrint(int[] data);
    int sum(int[] data);
}

/*
 * Modifica la interfaz DataOperations para que utilice interfaces funcionales en lugar de métodos concretos. 
 * Puedes usar las interfaces funcionales proporcionadas por Java, como Consumer y IntPredicate, en lugar de definir tu propia interfaz
 */