package Java3.Ej2;

import Java3.Ej2.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        VideogameDatabase database = new VideogameDatabase();

        database.addVideogame(new Videogame("Super Mario Odyssey", "Plataformas", 49.99));
        database.addVideogame(new Videogame("The Legend of Zelda: Breath of the Wild", "Aventura", 59.99));
        database.addVideogame(new Videogame("Resident Evil 7", "Terror", 39.99));
        database.addVideogame(new Videogame("FIFA 22", "Deportes", 59.99));
        database.addVideogame(new Videogame("Call of Duty: Warzone", "Disparos", 0.0));
        database.addVideogame(new Videogame("Minecraft", "Sandbox", 29.99));

        // Listar todos los títulos de los videojuegos
        System.out.println("Todos los títulos de los videojuegos:");
        List<String> allTitles = database.getAllTitles();
        for (String title : allTitles) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuyo precio sea superior a 20€
        System.out.println("Títulos de los videojuegos con precio superior a 20€:");
        List<String> titlesAbove20 = database.getTitlesWithPriceAbove(20.0);
        for (String title : titlesAbove20) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuya categoría sea terror
        System.out.println("Títulos de los videojuegos de la categoría 'Terror':");
        List<String> titlesInCategoryTerror = database.getTitlesWithCategory("Terror");
        for (String title : titlesInCategoryTerror) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuyo precio sea superior a 20€, ordenados ascendentemente por el precio
        System.out.println("Títulos de los videojuegos con precio superior a 20€ ordenados ascendentemente por precio:");
        List<String> titlesAbove20SortedAscending = database.getTitlesWithPriceAboveSortedByPriceAscending(20.0);
        for (String title : titlesAbove20SortedAscending) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuyo precio sea superior a 20€, ordenados descendentemente por el precio
        System.out.println("Títulos de los videojuegos con precio superior a 20€ ordenados descendentemente por precio:");
        List<String> titlesAbove20SortedDescending = database.getTitlesWithPriceAboveSortedByPriceDescending(20.0);
        for (String title : titlesAbove20SortedDescending) {
            System.out.println(title);
        }
        System.out.println();

        // Obtener el número de videojuegos agrupados por categoría
        System.out.println("Número de videojuegos agrupados por categoría:");
        Map<String, Long> videogamesByCategory = database.getNumberOfVideogamesByCategory();
        for (Map.Entry<String, Long> entry : videogamesByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // Obtener la suma de los precios de los videojuegos agrupados por categoría
        System.out.println("Suma de precios de los videojuegos agrupados por categoría:");
        Map<String, Double> pricesByCategory = database.getSumOfPricesByCategory();
        for (Map.Entry<String, Double> entry : pricesByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // Obtener la suma de los precios de los videojuegos agrupados por categoría, siempre que el precio sea superior a 200€
        System.out.println("Suma de precios de los videojuegos agrupados por categoría (precio > 200€):");
        Map<String, Double> pricesByCategoryWithThreshold = database.getSumOfPricesByCategoryWithThreshold(200.0);
        for (Map.Entry<String, Double> entry : pricesByCategoryWithThreshold.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

