
public class CommissionEmployee extends Employee {
    private double grossSales; // haftalık brüt satışlar
    private double commissionRate; // komisyon yüzdesi

    /**
     * five-argument constructor
     * @param first çalışanın adı
     * @param last çalışanın soyadı
     * @param ssn çalışanın sosyal güvenlik numarası
     * @param sales çalışanların brüt satışları
     * @param rate çalışanın komisyon oranı
     *
     * IllegalArgumentException: Metotlara geçersiz argüman atamalarında fırlatılır.
     *
     */
    public CommissionEmployee(String first, String last, String ssn,
                              double sales, double rate) {// yapıcı (constructor) metot
        super(first, last, ssn);
        setGrossSales(sales);
        setCommissionRate(rate);
    }


    public void setCommissionRate(double rate) {// commission rate set metodu
        //çalışanın komisyon oranı
        if (rate > 0.0 && rate < 1.0)
            commissionRate = rate;
        else
            throw new IllegalArgumentException(
                    "Komisyon oranı > 0.0 ve < 1.0");
    }


    public double getCommissionRate() {
        return commissionRate;
    }


    public void setGrossSales(double sales) { //gross sales amount(brüt satış tutarı) set metot
        if (sales >= 0.0)
            grossSales = sales;
        else
            throw new IllegalArgumentException(
                    "Brüt satışlar >= 0.0" );
    }

    public double getGrossSales() {//brüt satış tutarı değeri döndürülüyor
        return grossSales;
    }


    public double getPaymentAmount() { //maasş hesaplayan override metot
        return getCommissionRate() * getGrossSales();
    }

    /**
     * return String representation of CommissionEmployee object
     * @return String representation of CommissionEmployee object
     */
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
                "komisyon çalışanı", super.toString(),
                "brüt satış", getGrossSales(),
                "komisyon oranı", getCommissionRate());
    }
}
