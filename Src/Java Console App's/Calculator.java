import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // Kullanıcıdan veri almak için bir Scanner nesnesi oluştur
        Scanner scanner = new Scanner(System.in);

        System.out.println("Basit Hesap Makinesi");
        System.out.print("İşlem seçin (+, -, *, /): ");
        // Kullanıcının seçtiği işlem türünü al
        char islemTuru = scanner.next().charAt(0);

        // İşlem için kullanılacak iki sayıyı al
        System.out.print("Birinci sayıyı girin: ");
        int sayi1 = scanner.nextInt();

        System.out.print("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        // Sonuç değişkenini başlangıçta sıfıra ayarla
        int sonuc = 0;

        // Kullanıcıdan veri alan Scanner'ı kapat
        scanner.close();

        // Eğer işlem türü bölme (/) ise
        if (islemTuru == '/') {
            // Koşul açılıyor: Eğer ikinci sayı sıfıra eşit değilse
            if (sayi2 != 0) {
                // Bölme işlemi yapılır
                double bolme = (double) sayi1 / sayi2;
                System.out.println("Sonuç: " + bolme);
                System.exit(0); // Diğer işlemlerin yapılmasını engellemek için programı kapat
            } else {
                // Eğer ikinci sayı sıfırsa, sıfıra bölme hatası alınır
                System.out.println("Hata: Sıfıra bölme hatası!");
                return; // Programın sonlandırılmasını sağlar
            }
        } else if (islemTuru == '+') {
            sonuc = sayi1 + sayi2;
        } else if (islemTuru == '-') {
            sonuc = sayi1 - sayi2;
        } else if (islemTuru == '*') {
            sonuc = sayi1 * sayi2;
        } else {
            // Geçersiz işlem hatası alınır (örneğin: ())
            System.out.println("Geçersiz işlem.");
            return; // Programın sonlandırılmasını sağlar
        }

        System.out.println("Sonuç: " + sonuc);
    }
}
