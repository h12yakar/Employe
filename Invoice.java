
public class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    /**
     * four-argument constructor
     * @param part parça numarası
     * @param description açıklama
     * @param count
     * @param price ürün başına maliyet
     */
    public Invoice(String part, String description, int count,
                   double price) {
        partNumber = part;
        partDescription = description;
        setQuantity(count); // miktarı doğrula ve sakla
        setPricePerItem(price); // ürün başına fiyatı doğrulanıp saklanıyor
    }


    public void setPartNumber(String part) {//part numarası set ediliyor
        partNumber = part; // doğrulama
    }


    public String getPartNumber() {// part numarası get edip döndüren metot
        return partNumber;
    }


    public void setPartDescription(String description) {//açıklama set metotu
        partDescription = description; //doğrulama
    }


    public String getPartDescription() {//açıklama get metotu
        return partDescription;
    }


    public void setQuantity(int count) {//miktar hesaplayan  set metotu
        if ( count >= 0 )
            quantity = count;
        else
            throw new IllegalArgumentException("Miktar >= 0");
    }


    public int getQuantity() {//miktar hesaplayan get metotu
        return quantity;
    }


    public void setPricePerItem(double price) {//ürün başına fiyat set metotu
        if ( price >= 0.0 )
            pricePerItem = price;
        else
            throw new IllegalArgumentException(
                    "Öğe başına fiyat >= 0");
    }


    public double getPricePerItem() {//ürün başına fiyat get metotu
        return pricePerItem;
    }


    public String toString() {//override metot
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                "fatura", "parça numarası", getPartNumber(), getPartDescription(),
                "miktar", getQuantity(), "ürün başına fiyat", getPricePerItem());
    }


    public double getPaymentAmount() {//override metot
        return getQuantity() * getPricePerItem(); // toplam maliyeti hesaplanıyor
    }
}
