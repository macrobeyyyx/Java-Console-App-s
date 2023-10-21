import java.util.Scanner; // Scanner sınıfını içe aktar

public class AirplaneReservationSystem {
    public static void main(String[] args) {
        boolean[] koltuklar = new boolean[10]; // 10 koltuklu bir uçak

        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için bir Scanner nesnesi oluştur

        while (true) {
            // Kullanıcıya seçenekleri göster
            System.out.println("Lütfen aşağıdaki seçeneklerden birini seçin:");
            System.out.println("1. Boş koltukları göster");
            System.out.println("2. Koltuk rezervasyonu yap");
            System.out.println("3. Rezervasyonu iptal et");
            System.out.println("4. Çıkış");

            int secim = scanner.nextInt(); // Kullanıcının seçimini al

            switch (secim) {
                case 1:
                    bosKoltuklariGoster(koltuklar); // Boş koltukları gösterme işlemini çağır
                    break;
                case 2:
                    rezervasyonYap(koltuklar); // Koltuk rezervasyonu yapma işlemini çağır
                    break;
                case 3:
                    rezervasyonIptalEt(koltuklar); // Rezervasyonu iptal etme işlemini çağır
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor..."); // Çıkış yap ve Scanner'ı kapat
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }

    // Boş koltukları gösterme işlemi
    public static void bosKoltuklariGoster(boolean[] koltuklar) {
        System.out.println("Boş koltuklar:");
        for (int i = 0; i < koltuklar.length; i++) {
            if (!koltuklar[i]) {
                System.out.println("Koltuk " + (i + 1));
            }
        }
    }

    // Koltuk rezervasyonu yapma işlemi
    public static void rezervasyonYap(boolean[] koltuklar) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rezervasyon yapmak istediğiniz koltuğun numarasını girin: ");
        int koltukNo = scanner.nextInt();

        if (koltukNo < 1 || koltukNo > koltuklar.length) {
            System.out.println("Geçersiz koltuk numarası. Lütfen tekrar deneyin.");
        } else if (koltuklar[koltukNo - 1]) {
            System.out.println("Bu koltuk zaten rezerve edilmiş.");
        } else {
            koltuklar[koltukNo - 1] = true;
            System.out.println("Rezervasyon tamamlandı. Koltuk " + koltukNo + " sizin.");
        }
        scanner.close();
    }

    // Rezervasyonu iptal etme işlemi
    public static void rezervasyonIptalEt(boolean[] koltuklar) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rezervasyonu iptal etmek istediğiniz koltuğun numarasını girin: ");
        int koltukNo = scanner.nextInt();

        if (koltukNo < 1 || koltukNo > koltuklar.length) {
            System.out.println("Geçersiz koltuk numarası. Lütfen tekrar deneyin.");
        } else if (!koltuklar[koltukNo - 1]) {
            System.out.println("Bu koltuk zaten boş.");
        } else {
            koltuklar[koltukNo - 1] = false;
            System.out.println("Rezervasyon iptal edildi. Koltuk " + koltukNo + " boş.");
        }
        scanner.close();
    }
}
