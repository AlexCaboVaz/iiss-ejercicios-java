package Java3.Ej1.Ej2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VideogameDatabase {
    private List<Videogame> videogames;

    public VideogameDatabase() {
        this.videogames = new ArrayList<>();
    }

    public void addVideogame(Videogame videogame) {
        videogames.add(videogame);
    }

    public List<String> getAllTitles() {
        return videogames.stream()
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAbove(double price) {
        return videogames.stream()
                .filter(v -> v.getPrice() > price)
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithCategory(String category) {
        return videogames.stream()
                .filter(v -> v.getCategory().equalsIgnoreCase(category))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAboveSortedByPrice(double price) {
        return videogames.stream()
                .filter(v -> v.getPrice() > price)
                .sorted(Comparator.comparingDouble(Videogame::getPrice))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAboveSortedByPriceDescending(double price) {
        return videogames.stream()
                .filter(v -> v.getPrice() > price)
                .sorted(Comparator.comparingDouble(Videogame::getPrice).reversed())
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getVideogamesCountByCategory() {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.counting()));
    }

    public Map<String, Double> getSumOfPricesByCategory() {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.summingDouble(Videogame::getPrice)));
    }

    public Map<String, Double> getSumOfPricesByCategoryAboveThreshold(double threshold) {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.summingDouble(Videogame::getPrice)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
