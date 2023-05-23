package Java1.Ejercicio2;

class DataSorterDesc implements DataSorter {
    private SortFunction sortFunction;

    public DataSorterDesc(SortFunction sortFunction) {
        this.sortFunction = sortFunction;
    }

    public String[] sort(String[] data) {
        return sortFunction.sort(data);
    }
}