import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için bir Scanner nesnesi oluştur
        Scanner scanner = new Scanner(System.in);

        // Kullanıcının okuduğu okul türünü (Lise veya Üniversite) öğren
        System.out.print("Lise mi (L) yoksa Üniversite mi (Ü) okuyorsunuz? (L/Ü): ");
        String okulTuru = scanner.next();

        // Toplam ders sayısını öğren
        System.out.print("Toplam ders sayısını girin: ");
        int toplamDersSayisi = scanner.nextInt();

        // Sınıf geçme notunu öğren
        System.out.print("Sınıf geçme notunu girin: ");
        double sinifGecmeNotu = scanner.nextDouble();

        // Toplam not değerini saklamak için bir değişken tanımla (double) ve kalan ders sayısını saklamak için bir değişken tanımla (int)
        double toplamNot = 0;
        int kalanDersSayisi = 0;

        // Girilen ders sayısına göre ders notlarını al ve toplam nota ekle
        for (int i = 1; i <= toplamDersSayisi; i++) {
            System.out.print("Ders " + i + " notunu girin: ");
            double dersNotu = scanner.nextDouble();
            toplamNot += dersNotu;

            // Ders notu sınıf geçme notundan düşükse, kalan ders sayısını artır
            if (dersNotu < sinifGecmeNotu) {
                kalanDersSayisi++;
            }
        }

        // Kullanıcıdan alınan veriyi içeren Scanner'ı kapat
        scanner.close();

        // Ortalama notu hesapla
        double ortalamaNot = toplamNot / toplamDersSayisi;
        System.out.println("Ortalama Not: " + ortalamaNot);
        System.out.println("Başarılı Ders Sayısı: " + (toplamDersSayisi - kalanDersSayisi));
        System.out.println("Kalan Ders Sayısı: " + kalanDersSayisi);

        // Mantıksal işlem: Kullanıcının okul türüne ve başarı durumuna göre mesaj ver
        if (okulTuru.equalsIgnoreCase("L")) { // Lise
            if (kalanDersSayisi > 3 || ortalamaNot < 55) {
                System.out.println("Sınıfta kaldınız!");
            } else {
                System.out.println("Sınıfı geçtiniz!");
            }
        } else if (okulTuru.equalsIgnoreCase("Ü")) { // Üniversite
            if (kalanDersSayisi > 2 || ortalamaNot < 60) {
                System.out.println("Sınıfta kaldınız!");
            } else {
                System.out.println("Sınıfı geçtiniz!");
            }
        } else {
            System.out.println("Geçersiz okul türü seçimi.");
        }
    }
}
