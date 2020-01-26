
/*
 * This is my model
 */
public class Inventar {

    private String name;
    private int quantity;
    private float price;

    public void setName(String n) {
        this.name=n;
    }
    public String getName() {
        return name;
    }
    public void setQuantity(int n) {
        this.quantity=n;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setPrice(float n) {
        this.price=n;
    }
    public float getPrice() {
        return price;
    }
}
