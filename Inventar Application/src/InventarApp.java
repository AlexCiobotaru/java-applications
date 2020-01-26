
import javax.swing.*;

/**
 * Implement a simplified product inventory management application in Java.
 * The product has the following characteristics: name, quantity and price.
 * The application offers the following features: adding new product,
 * viewing product list, changing existing product quantity and
 * deleting product. Use the MVC design pattern to implement
 * this application.
 */

public class InventarApp {

    public static void main(String[] args) {
        JFrame presentation = new InventarView();
        presentation.setSize(750,350);
        presentation.setVisible(true);
    }
}
