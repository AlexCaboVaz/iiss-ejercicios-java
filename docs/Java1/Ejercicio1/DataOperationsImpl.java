package Java1.Ejercicio1;

import java.util.Arrays;
import java.util.List;

public class DataOperationsImpl implements DataOperations {
    @Override
    public void print(int[] data) {
        Arrays.stream(data).forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    @Override
    public int[] filterPairs(int[] data) {
        return Arrays.stream(data)
                .filter(element -> (element % 2) != 0)
                .toArray();
    }

    @Override
    public List<Integer> sortDescending(int[] data) {
        return Arrays.stream(data)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .toList();
    }

    @Override
    public void multiplyByTenAndPrint(int[] data) {
        Arrays.stream(data)
                .map(element -> element * 10)
                .forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    @Override
    public int sum(int[] data) {
        return Arrays.stream(data).sum();
    }
}