import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Product, Integer> shoppingCart;

    public ShoppingCart() {
        shoppingCart = new HashMap<Product, Integer>();
    }

    public void addProduct(Product product, int number) {
        assert number > 0 : "El número de unidades debe ser mayor que cero";

        if (shoppingCart.keySet().stream().filter(element -> element.getCode() == product.getCode()).count() == 0) {
            shoppingCart.put(product, number);
        }
    }

    public Product removeProduct(Product product) {
        assert shoppingCart.containsKey(product) : "El producto no existe en el carrito";
        if (shoppingCart.containsKey(product)) {
            shoppingCart.remove(product);
            return product;
        } else {
            return null;
        }
    }

    public void printShoppingCartContent() {
        System.out.println("El contenido del carrito de compras es:");
        for (Product product : shoppingCart.keySet()) {
            System.out.println(product.getCode() + " - " + product.getName().orElse("Sin nombre") + " : " + shoppingCart.get(product));
        }
    }
}
