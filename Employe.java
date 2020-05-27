
public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    /**
     * three-argument constructor
     * @param first çalışanın adı
     * @param last çalışanın soyadı
     * @param ssn çalışanın sosyal güvenlik numarası
     */
    public Employee(String first, String last, String ssn) {//Kurucu metot
        firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
    }


    public void setFirstName(String first) {// çalışanın adını set eden metot
        firstName = first; // doğrulamala
    }


    public String getFirstName() { // çalışanın adını get ile döndüren metot
        return firstName;
    }


    public void setLastName(String last) {//çalışanın soy adını set eden metot
        lastName = last; // doğrulamala
    }


    public String getLastName() {// soyadı döndüren get metotu
        return lastName;
    }


    public void setSocialSecurityNumber(String ssn) {//güvenlik numarasını set eden metot
        socialSecurityNumber = ssn; // doğrulamala
    }


    public String getSocialSecurityNumber() {//güvenlik numarasını get eden metot
        return socialSecurityNumber;
    }


    @Override
    public String toString() {
        return String.format( "%s %s%nsocial güvenlik numarası: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

}
