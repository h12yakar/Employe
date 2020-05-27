
public class PayrollSystemTest {
    public static void main(String[] args) {
        // alt sınıf nesneleri yaratılıyor
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("Habip", "Yakar", "111-11-1111", 800.00);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Mehmet", "Şevket", "222-22-2222", 16.75, 40);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        "Aslım", "Sıla", "333-33-3333", 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee(
                        "Can", "Cem", "444-44-4444", 5000, .04, 300);

        System.out.println("Bireysel olarak işlenen çalışanlar:%n");

        System.out.printf("%s%n%s: $%,.2f%n%n",
                salariedEmployee, "kazanılan", salariedEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "kazanılan", hourlyEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "kazanılan", commissionEmployee.getPaymentAmount());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "kazanılan", basePlusCommissionEmployee.getPaymentAmount());

        // dört elemanlı Çalışan dizisi oluşturuluyor
        Employee[] employees = new Employee[4];

        // Employees diziyle initialize ediliyor
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        System.out.printf( "Polimorfik olarak işlenen çalışanlar:%n%n" );

        // dizi çalışanlarındaki her öğeyi genel olarak işleniyor
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); //toString metotu çağrılıyor

            // öğenin BasePlusCommissionEmployee olup olmadığını belirleme
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // BasePlusCommissionEmployee referansına göre çalışan referansı

                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "%% 10 artışla yeni baz maaş: $%,.2f%n",
                        employee.getBaseSalary());
            }

            System.out.printf(
                    "kazanılan $%,.2f%n%n", currentEmployee.getPaymentAmount());
        }

        // çalışanlar dizisindeki her nesnenin tür adını alın
        for (int j = 0; j < employees.length; j++)
            System.out.printf( "Çalışan %d is a %s%n", j,
                    employees[j].getClass().getName());
    }
}
