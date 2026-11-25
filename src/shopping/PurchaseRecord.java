package shopping;

/**
 * A purchase the user has made. Every purchase is either an EcoPurchase
 * or a StandardPurchase, so this class is abstract.
 */
public abstract class PurchaseRecord implements Scorable {

    private String productName;
    private String category;
    private double price;
    private String sustainabilityClass; // A, B, C or D

    public PurchaseRecord(String productName, String category, double price, String sustainabilityClass) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.sustainabilityClass = sustainabilityClass;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getSustainabilityClass() {
        return sustainabilityClass;
    }

    public void setSustainabilityClass(String sustainabilityClass) {
        this.sustainabilityClass = sustainabilityClass;
    }

    // Starting score from the sustainability class: A = 8, B = 6, C = 4, D = 2
    protected int getClassScore() {
        switch (sustainabilityClass) {
            case "A":
                return 8;
            case "B":
                return 6;
            case "C":
                return 4;
            default:
                return 2;
        }
    }

    // "Eco-friendly" or "Standard"
    public abstract String getPurchaseType();

    // One line of text used when saving the purchase to a file
    public abstract String toFileString();

    @Override
    public String toString() {
        return productName + " (" + category + ") - €" + String.format("%.2f", price)
                + " - Class " + sustainabilityClass + " - Score " + getSustainabilityScore() + "/10";
    }
}
