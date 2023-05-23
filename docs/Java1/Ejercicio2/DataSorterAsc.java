package Java1.Ejercicio2;

class DataSorterAsc implements DataSorter {
    private SortFunction sortFunction;

    public DataSorterAsc(SortFunction sortFunction) {
        this.sortFunction = sortFunction;
    }

    public String[] sort(String[] data) {
        return sortFunction.sort(data);
    }
}