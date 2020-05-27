
public class PayableInterfaceTest {
    public static void main(String[] args) {
        // dört öğeli Ödenebilir dizi oluşturuluyor
        Payable[] payableObjects = new Payable[4];

        // populate array with objects that implement Payable
        payableObjects[0] = new Invoice("01234", "yer", 2, 375.00);
        payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
        payableObjects[2] =
                new SalariedEmployee("Habip", "Yakar", "111-11-1111", 800.00);
        payableObjects[3] =
                new SalariedEmployee("Ali", "Veli", "888-88-8888", 1200.00);

        System.out.println(
                "Polimorfik olarak işlenen Faturalar ve Çalışanlar:");

        // payableObjects dizisindeki her öğeyi genel olarak işler
        for (Payable currentPayable : payableObjects) {
            // çıktı currentPayable ve uygun ödeme tutarı
            System.out.printf("%s %n%s: $%,.2f%n%n",
                    currentPayable.toString(),
                    "ödenmesi gereken tutar", currentPayable.getPaymentAmount());
        }
    }
}
