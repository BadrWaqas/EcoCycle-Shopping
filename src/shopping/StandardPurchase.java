package shopping;

/**
 * A purchase of a regular product. Its packaging changes the score.
 */
public class StandardPurchase extends PurchaseRecord {

    private String packagingType;

    public StandardPurchase(String productName, String category, double price,
                            String sustainabilityClass, String packagingType) {
        super(productName, category, price, sustainabilityClass);
        this.packagingType = packagingType;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    // Plastic packaging loses a point, no packaging gains a point
    @Override
    public int getSustainabilityScore() {
        int score = getClassScore();
        if ("Plastic".equals(packagingType)) {
            score = score - 1;
        } else if ("No packaging".equals(packagingType)) {
            score = score + 1;
        }
        return Math.max(0, Math.min(score, 10));
    }

    @Override
    public String getPurchaseType() {
        return "Standard";
    }

    @Override
    public String toFileString() {
        return "STANDARD|" + getProductName() + "|" + getCategory() + "|" + getPrice()
                + "|" + getSustainabilityClass() + "|" + packagingType;
    }
}
