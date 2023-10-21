import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGen {

    public static void main(String[] args) {
			  // Kullancımızdan Veri Alacak Scannerimizi Tanımlıyoruz 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Şifre uzunluğunu girin: ");
        int uzunluk = scanner.nextInt();
        
        // Şifre oluştur
        String sifre = sifreOlustur(uzunluk);
        
        // Oluşturulan şifreyi ekrana yazdır
        System.out.println("Oluşturulan şifre: " + sifre);
				// Kullancımızdan Veri Alan Scannerimizi Kapatıyoruz 
				scanner.close();
    }
    // "sifreOlustur" 13 Satır 46 Kelimede Tanımlanan Fonkisyon
    public static String sifreOlustur(int uzunluk) {
        String karakterler = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom rastgele = new SecureRandom();
        StringBuilder sifre = new StringBuilder(uzunluk);
				
        // Belirtilen Uzunluğa kadar Şifre Oluşturan Kod Bloğu
        for (int i = 0; i < uzunluk; i++) {
            int rastgeleIndex = rastgele.nextInt(karakterler.length());
            char rastgeleKarakter = karakterler.charAt(rastgeleIndex);
            sifre.append(rastgeleKarakter);
        }
				
				// Şifreyi Metine Dökme Ve Yansıtme
        return sifre.toString();
				
    }
}
