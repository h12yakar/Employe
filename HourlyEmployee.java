
public class HourlyEmployee extends Employee {// HourlyEmployee Employee sınıfana extend ediliyor
    private double wage; // saat başına ücret
    private double hours; // hafta boyunca çalışılan saatler

    /**
     * five-argument constructor
     * @param first çalışanın adı
     * @param last çalışanın soyadı
     * @param ssn çalışanın sosyal güvenlik numarası
     * @param hourlyWage saatlik çalışan ücreti
     * @param hoursWorked çalışan tarafından çalışılan saat sayısı
     */
    public HourlyEmployee(String first, String last, String ssn,
                          double hourlyWage, double hoursWorked) {// constructor(yapıcı) metot
        super(first, last, ssn);
        setWage(hourlyWage); // saatlik ücreti doğrulayıp saklanıyor
        setHours(hoursWorked); // başlangıç ücreti doğrulayınıp saklanıyor
    }


    public void setWage(double hourlyWage) {// set maaş metotu ile saatlik çalışan ücreti hesaplama
        if (hourlyWage >= 0.0)
            wage = hourlyWage;
        else
            throw new IllegalArgumentException(
                    "Saatlik ücret >= 0.0" );
    }


    public double getWage() {//get ile maaş return ediliyor
        return wage;
    }


    public void setHours(double hoursWorked)
    {//çalışan haftalık maaş set ediliyor
        if ( ( hoursWorked >= 0.0 ) && ( hoursWorked <= 168.0 ) )
            hours = hoursWorked;
        else
            throw new IllegalArgumentException(
                    "Çalışılan saatler >= 0.0 and <= 168.0" );
    }


    public double getHours() {//haftalık çalışan get metotu
        return hours;
    }


    public double getPaymentAmount() {//maaş hesaplama override metotu
        if (getHours() <= 40) // fazla mesai yok
            return getWage() * getHours();
        else
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }


    public String toString()
    {
        return String.format( "saatlik çalışan: %s%n%s: $%,.2f; %s: %,.2f",
                super.toString(), "saatlik ücret", getWage(),
                "çalışılan saatler", getHours() );
    }
}
