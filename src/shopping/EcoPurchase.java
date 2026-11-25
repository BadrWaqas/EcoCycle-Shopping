package shopping;

/**
 * A purchase of an eco-friendly product, which can carry an eco label.
 */
public class EcoPurchase extends PurchaseRecord {

    private String ecoLabel;

    public EcoPurchase(String productName, String category, double price,
                       String sustainabilityClass, String ecoLabel) {
        super(productName, category, price, sustainabilityClass);
        this.ecoLabel = ecoLabel;
    }

    public String getEcoLabel() {
        return ecoLabel;
    }

    public void setEcoLabel(String ecoLabel) {
        this.ecoLabel = ecoLabel;
    }

    // Eco products get 2 extra points if they have a certified eco label
    @Override
    public int getSustainabilityScore() {
        int score = getClassScore();
        if (ecoLabel != null && !ecoLabel.trim().isEmpty()) {
            score = score + 2;
        }
        return Math.min(score, 10);
    }

    @Override
    public String getPurchaseType() {
        return "Eco-friendly";
    }

    @Override
    public String toFileString() {
        return "ECO|" + getProductName() + "|" + getCategory() + "|" + getPrice()
                + "|" + getSustainabilityClass() + "|" + ecoLabel;
    }
}
