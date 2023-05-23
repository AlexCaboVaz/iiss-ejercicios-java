package Java3.Ej2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VideogameDatabase {

    private List<Videogame> videogames;

    public VideogameDatabase() {
        videogames = new ArrayList<>();
    }

    public void addVideogame(Videogame videogame) {
        videogames.add(videogame);
    }

    public List<String> getAllTitles() {
        return videogames.stream()
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAbove(double priceThreshold) {
        return videogames.stream()
                .filter(v -> v.getPrice() > priceThreshold)
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithCategory(String category) {
        return videogames.stream()
                .filter(v -> v.getCategory().equals(category))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAboveSortedByPriceAscending(double priceThreshold) {
        return videogames.stream()
                .filter(v -> v.getPrice() > priceThreshold)
                .sorted((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAboveSortedByPriceDescending(double priceThreshold) {
        return videogames.stream()
                .filter(v -> v.getPrice() > priceThreshold)
                .sorted((v1, v2) -> Double.compare(v2.getPrice(), v1.getPrice()))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getNumberOfVideogamesByCategory() {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.counting()));
    }

    public Map<String, Double> getSumOfPricesByCategory() {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.summingDouble(Videogame::getPrice)));
    }

    public Map<String, Double> getSumOfPricesByCategoryWithThreshold(double priceThreshold) {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory,
                        Collectors.summingDouble(Videogame::getPrice)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > priceThreshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
