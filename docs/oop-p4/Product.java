import java.util.Optional;

public class Product {

    private int code;
    private Optional<String> name;
    private Optional<String> category;
    private double weight;
    private double height;

    public Product(int code, String name, String category, double weight, double height) {
        assert code >= 0 : "El código no puede ser negativo";
        assert weight >= 0 : "El peso no puede ser negativo";
        assert height >= 0 : "La altura no puede ser negativa";

        this.code = code;
        this.name = Optional.ofNullable(name);
        this.category = Optional.ofNullable(category);
        this.weight = weight;
        this.height = height;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        assert name != null && !name.isEmpty() : "El nombre no puede estar vacío";
        this.name = Optional.of(name);
    }

    public Optional<String> getName() {
        return name;
    }

    public void setCategory(String category) {
        assert category != null && !category.isEmpty() : "La categoría no puede estar vacía";
        this.category = Optional.of(category);
    }

    public Optional<String> getCategory() {
        return category;
    }

    public void setWeight(double weight) {
        assert weight >= 0 : "El peso no puede ser negativo";
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        assert height >= 0 : "La altura no puede ser negativa";
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
