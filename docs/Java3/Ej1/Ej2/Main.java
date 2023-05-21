package Java3.Ej1.Ej2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        VideogameDatabase database = new VideogameDatabase();

        // Agregar videojuegos a la base de datos
        database.addVideogame(new Videogame("The Legend of Zelda: Breath of the Wild", "Adventure", 59.99));
        database.addVideogame(new Videogame("Resident Evil 7: Biohazard", "Horror", 29.99));
        database.addVideogame(new Videogame("Super Mario Odyssey", "Platformer", 49.99));
        database.addVideogame(new Videogame("The Last of Us Part II", "Action", 59.99));
        database.addVideogame(new Videogame("Resident Evil 2 Remake", "Horror", 39.99));
        database.addVideogame(new Videogame("Doom Eternal", "Action", 39.99));

        // Listar todos los títulos de los videojuegos
        System.out.println("Todos los títulos:");
        List<String> allTitles = database.getAllTitles();
        for (String title : allTitles) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuyo precio sea superior a 20€
        System.out.println("Títulos con precio superior a 20€:");
        List<String> titlesAbovePrice = database.getTitlesWithPriceAbove(20.0);
        for (String title : titlesAbovePrice) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuya categoría sea "Horror"
        System.out.println("Títulos de la categoría 'Horror':");
        List<String> titlesInCategory = database.getTitlesWithCategory("Horror");
        for (String title : titlesInCategory) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuyo precio sea superior a 20€ ordenados ascendentemente por el precio
        System.out.println("Títulos con precio superior a 20€ ordenados ascendentemente por el precio:");
        List<String> titlesAbovePriceSorted = database.getTitlesWithPriceAboveSortedByPrice(20.0);
        for (String title : titlesAbovePriceSorted) {
            System.out.println(title);
        }
        System.out.println();

        // Listar los títulos de los videojuegos cuyo precio sea superior a 20€ ordenados descendentemente por el precio
        System.out.println("Títulos con precio superior a 20€ ordenados descendentemente por el precio:");
        List<String> titlesAbovePriceSortedDescending = database.getTitlesWithPriceAboveSortedByPriceDescending(20.0);
        for (String title : titlesAbovePriceSortedDescending) {
            System.out.println(title);
        }
        System.out.println();

        // Obtener el número de videojuegos agrupados por categoría
        System.out.println("Número de videojuegos agrupados por categoría:");
        Map<String, Long> videogamesCountByCategory = database.getVideogamesCountByCategory();
        for (Map.Entry<String, Long> entry : videogamesCountByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // Obtener la suma de los precios de los videojuegos agrupados por categoría
        System.out.println("Suma de precios de videojuegos agrupados por categoría:");
        Map<String, Double> sumOfPricesByCategory = database.getSumOfPricesByCategory();
        for (Map.Entry<String, Double> entry : sumOfPricesByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // Obtener la suma de los precios de los videojuegos agrupados por categoría con suma superior a 200€
        System.out.println("Suma de precios de videojuegos agrupados por categoría (suma superior a 200€):");
        Map<String, Double> sumOfPricesByCategoryAboveThreshold = database.getSumOfPricesByCategoryAboveThreshold(200.0);
        for (Map.Entry<String, Double> entry : sumOfPricesByCategoryAboveThreshold.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
