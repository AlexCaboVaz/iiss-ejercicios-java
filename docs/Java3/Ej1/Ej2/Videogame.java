package Java3.Ej1.Ej2;

public class Videogame {
    private String title;
    private String category;
    private double price;

    public Videogame(String title, String category, double price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Videogame game = new Videogame("The Legend of Zelda: Breath of the Wild", "Adventure", 59.99);
        System.out.println(game.getTitle()); // Imprime "The Legend of Zelda: Breath of the Wild"
        System.out.println(game.getCategory()); // Imprime "Adventure"
        System.out.println(game.getPrice()); // Imprime 59.99

        game.setPrice(49.99);
        System.out.println(game.getPrice()); // Imprime 49.99 (nuevo precio asignado)
    }
}

