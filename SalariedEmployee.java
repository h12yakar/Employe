
public class SalariedEmployee extends Employee {
    private double weeklySalary;

    /**
     * four-argument constructor
     * @param first çalışanın adı
     * @param last çalışanın soyadı
     * @param ssn çalışanın sosyal güvenlik numarası
     * @param salary çalışanın maaşı
     */
    public SalariedEmployee(String first, String last, String ssn,
                            double salary) {
        super(first, last, ssn); // Employee constructor u pas geçiliyor
        setWeeklySalary(salary); // maaşı doğrulayın ve saklayın
    }


    public void setWeeklySalary(double salary) {//çalışanın maaşı set ediliyor
        if ( salary >= 0.0 )
            weeklySalary = salary;
        else
            throw new IllegalArgumentException(
                    "Haftalık maaş >= 0.0" );
    }


    public double getWeeklySalary() {//çalışan maaşı get metotu ile döndürülüyor
        return weeklySalary;
    }


    public double getPaymentAmount() {//override metot
        return getWeeklySalary();
    }


    public String toString() {
        return String.format("Maaşlı çalışan: %s%n%s: $%,.2f",
                super.toString(), "haftalık maaş", getWeeklySalary());
    }
}
