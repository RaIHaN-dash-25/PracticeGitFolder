package main.midpracticecart;

public class Payment {
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private Double predefinedVat;
    private Double vatAmount;
    private Double totalAmount;

    public Payment() {
    }

    public Payment(String productName, Double unitPrice, Integer quantity, Double predefinedVat, Double vatAmount, Double totalAmount) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.predefinedVat = predefinedVat;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Double getPredefinedVat() {
        return predefinedVat;
    }

    public void setPredefinedVat(Double predefinedVat) {
        this.predefinedVat = predefinedVat;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", predefinedVat=" + predefinedVat +
                ", vatAmount=" + vatAmount +
                ", totalAmount=" + totalAmount +
                '}';
    }


}
