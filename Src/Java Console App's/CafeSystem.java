import java.util.Scanner; // Scanner sınıfını içe aktar
import java.util.HashMap; // HashMap sınıfını içe aktar

public class CafeSystem {
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için bir Scanner nesnesi tanımla
        Scanner scanner = new Scanner(System.in);

        // Ürün bilgilerini ve siparişleri saklamak için HashMap'leri tanımla
        HashMap<String, Double> urunler = new HashMap<>();
        HashMap<String, Integer> siparisler = new HashMap<>();

        // Ürün bilgilerini HashMap'e ekle
        urunler.put("Çay", 2.0);
        urunler.put("Kahve", 3.0);
        urunler.put("Sandviç", 5.0);
        urunler.put("Meyve Suyu", 4.0);

        // Sonsuz bir döngü oluştur ve kullanıcının işlemlerini seçmesini sağla
        boolean devamEt = true;
        while (devamEt) {
            // Kullanıcıya mevcut ürünleri göster
            System.out.println("Kantin Ürünleri:");
            for (String urun : urunler.keySet()) {
                System.out.println(urun + " - " + urunler.get(urun) + " TL");
            }

            // Kullanıcıya işlem seçeneklerini göster
            System.out.println("Lütfen bir işlem seçin:");
            System.out.println("1. Ürün Satın Alma");
            System.out.println("2. Sipariş Geçmişi Görüntüle");
            System.out.println("3. Çıkış");

            // Kullanıcının seçimini al
            int secim = scanner.nextInt();

            // Kullanıcının seçimine göre işlem yap
            switch (secim) {
                case 1:
                    urunSatınAl(urunler, siparisler); // Ürün satın alma işlemini çağır
                    break;
                case 2:
                    siparisGecmisiGoruntule(siparisler); // Sipariş geçmişini görüntüleme işlemini çağır
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor..."); // Çıkış yap ve döngüyü sonlandır
                    devamEt = false;
                    break;
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }

        // Kullanıcıdan veri alan Scanner'ı kapat
        scanner.close();
    }

    // Ürün satın alma işlemi
    public static void urunSatınAl(HashMap<String, Double> urunler, HashMap<String, Integer> siparisler) {
        // Kullanıcıdan veri almak için bir Scanner nesnesi tanımla
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satın almak istediğiniz ürünü seçin: ");
        String urun = scanner.nextLine();

        // Eğer seçilen ürün urunler HashMap'inde bulunuyorsa
        if (urunler.containsKey(urun)) {
            System.out.print("Kaç adet almak istiyorsunuz: ");
            int adet = scanner.nextInt();

            // Toplam fiyatı hesapla
            double toplamFiyat = urunler.get(urun) * adet;

            // Eğer siparisler HashMap'inde seçilen ürün varsa
            if (siparisler.containsKey(urun)) {
                // Var olan siparişe yeni adeti ekler
                siparisler.put(urun, siparisler.get(urun) + adet);
            } else {
                // Yeni bir sipariş oluşturur
                siparisler.put(urun, adet);
            }

            // Sipariş alındı mesajını ve toplam tutarı yazdır
            System.out.println("Siparişiniz alındı. Toplam Tutar: " + toplamFiyat + " TL");
        } else {
            // Geçersiz ürün seçimi mesajını yazdır
            System.out.println("Geçersiz ürün seçimi.");
        }

        // Kullanıcıdan veri alan Scanner'ı kapat
        scanner.close();
    }

    // Sipariş geçmişi görüntüleme işlemi
    public static void siparisGecmisiGoruntule(HashMap<String, Integer> siparisler) {
        // Sipariş geçmişini görüntüleme işlevi
        System.out.println("Sipariş Geçmişi:");
        // Siparişler HashMap'indeki her ürünün adetini listele
        for (String urun : siparisler.keySet()) {
            System.out.println(urun + " - " + siparisler.get(urun) + " adet");
        }
    }
}
