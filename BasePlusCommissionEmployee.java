
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // haftalık baz maaş

    /**
     * six argument constructor
     * @param first çalışanın adı
     * @param last çalışanın soyadı
     * @param ssn çalışanın sosyal güvenlik numarası
     * @param sales çalışanın toplam satışı
     * @param rate çalışanın komisyon oranı
     * @param salary çalışanın brüt maaşı
     *
     * IllegalArgumentException: Metotlara geçersiz argüman atamalarında fırlatılır.
     *
     */
    public BasePlusCommissionEmployee(String first, String last,
                                      String ssn, double sales, double rate, double salary) {
        super(first, last, ssn, sales, rate);
        setBaseSalary(salary); // asgari ücret doğrulayınıp ve saklayor
    }


    public void setBaseSalary(double salary) { //çalışanın temel maaşı set eden metot
        if (salary >= 0.0)
            baseSalary = salary;
        else
            throw new IllegalArgumentException(
                    "Temel maaş >= 0.0" );
    }


    public double getBaseSalary() {//Asgari ücret get ediliyor
        return baseSalary;
    }


    public double getPaymentAmount() {//ödemeyi hesaplanıyor; CommissionEmployee içinde getPaymentAmount metotu override ediliyor
        return getBaseSalary() + super.getPaymentAmount();
    }


    public String toString() {//BasePlusCommissionEmployee ile oluşturalan nesne ile override ediliyor
        return String.format("%s %s; %s: $%,.2f",
                "taban maaşları", super.toString(),
                "Asgari ücret", getBaseSalary());
    }
}
