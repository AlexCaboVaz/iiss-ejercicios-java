## Segunda Parte

### Clase VideoGame
- La clase Videogame tiene los atributos title (título del videojuego), category (categoría del videojuego) y price (precio del videojuego). También se proporcionan los métodos set y get para acceder a estos atributos.

- Puedes utilizar esta clase para crear objetos Videogame con sus respectivos títulos, categorías y precios, y acceder a estos atributos utilizando los métodos get y set

### Clase VideoGameDataBase

- La clase VideogameDatabase contiene una lista de videojuegos (videogames) y proporciona las operaciones solicitadas utilizando el Stream API de Java 8:

1. getAllTitles(): Devuelve una lista con todos los títulos de los videojuegos existentes.
2. getTitlesWithPriceAbove(double priceThreshold): Devuelve una lista con los títulos de los videojuegos cuyo precio es superior al umbral dado.
3. getTitlesWithCategory(String category): Devuelve una lista con los títulos de los videojuegos de una categoría específica.
4. getTitlesWithPriceAboveSortedByPriceAscending(double priceThreshold): Devuelve una lista con los títulos de los videojuegos cuyo precio es superior al umbral dado, ordenados ascendentemente por el precio.
5. getTitlesWithPriceAboveSortedByPriceDescending(double priceThreshold): Devuelve una lista con los títulos de los videojuegos cuyo precio es superior al umbral dado, ordenados descendentemente por el precio.
6. getNumberOfVideogamesByCategory(): Devuelve un mapa que agrupa el número de videojuegos por categoría.
7. getSumOfPricesByCategory(): Devuelve un mapa que agrupa la suma de los precios de los videojuegos por categoría.
8. getSumOfPricesByCategoryWithThreshold(double priceThreshold): Devuelve un mapa que agrupa la suma de los precios de los videojuegos por categoría, siempre y cuando la suma sea superior al umbral dado.
Puedes utilizar la clase VideogameDatabase para agregar videojuegos, realizar consultas y obtener los resultados deseados utilizando el Stream API de Java 8.

### Main Prueba

- Este programa de prueba crea una instancia de VideogameDatabase, agrega algunos videojuegos a la base de datos y luego realiza las operaciones requeridas utilizando los métodos de la clase VideogameDatabase. Cada operación se imprime en la consola para mostrar los resultados.

- Asegúrate de tener ambas clases, Videogame y VideogameDatabase, en tu proyecto y ejecuta el programa Main para ver los resultados de las operaciones.