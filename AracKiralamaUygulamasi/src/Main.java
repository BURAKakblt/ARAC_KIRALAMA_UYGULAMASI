import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AracKiralama aracKiralama = new AracKiralama();


        Otomobil araba1 = new Otomobil("Ford", "Focus", 2024, 150, 5, "Dizel");
        Kamyon kamyon1 = new Kamyon("Ford", "F-MAX", 2023, 350, "Hafriyat", 15000, 10);
        AraziAraci atv1 = new AraziAraci("Yamaha", "H350", 2022, 75, 4, 2);
        Motorsiklet motorsiklet1 = new Motorsiklet("Yamaha", "R-25", 2021, 50);
        Motorsiklet.yarisMotorsikleti yarisMotorsikleti1 = new Motorsiklet.yarisMotorsikleti("Honda","CRM",2024,1000);
        Motorsiklet.dagMotorsikleti dagMotorsikleti1 = new  Motorsiklet.dagMotorsikleti("BMW","X-350",2022,1200);


        aracKiralama.aracEkle(araba1);
        aracKiralama.aracEkle(kamyon1);
        aracKiralama.aracEkle(atv1);
        aracKiralama.aracEkle(motorsiklet1);
        aracKiralama.aracEkle(yarisMotorsikleti1);
        aracKiralama.aracEkle(dagMotorsikleti1);


        while (true) {
            printMenu();
            int secim = girisKontrol(scanner);
            switch (secim) {
                case 1: {
                    kiralamaIslemi(scanner, aracKiralama);
                    break;

                }
                case 2: {
                    aracIadeIslemi(scanner, aracKiralama);
                    break;
                }
                case 3: {
                    aracKiralama.kiralamaBilgiGoster();

                    System.out.print("Belirli türde bir araç bilgisi görmek istiyorsanız, türü giriniz (Otomobil, Kamyon, vb.): ");
                    String aracTuru = scanner.next();
                    aracKiralama.kiralamaBilgiGoster(aracTuru);

                    System.out.print("Belirli bir yıl için araç bilgisi görmek istiyorsanız, yılı giriniz: ");
                    int yil = girisKontrol(scanner);
                    aracKiralama.kiralamaBilgiGoster(yil);
                        break;
                }

                case 4: {
                    aracEklemeIslemi(scanner, aracKiralama);
                    break;
                }
                case 5 : {

                    System.out.println("Araç Kiralama Sistemini kullandığınız için teşekkür ederiz. Hoşça kal!");
                    break;
                }
                default:
                    System.out.println("Geçersiz secim tekrar deneyiniz...");


            }
            if (secim == 5) {
                break;
            }
        }
    }


    private static int girisKontrol(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Lütfen bir sayı giriniz: ");
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Hatalı giriş yaptınız. Lütfen geçerli bir sayı giriniz.");
                scanner.nextLine();
            }
        }
    }



    private static void printMenu() {
        System.out.println("**********Arac Kiralama Uygulamasi**********");
        System.out.println("1.Arac Kirala");
        System.out.println("2. Arac Iade Et");
        System.out.println("3. Kiralama Bilgilerini Goster");
        System.out.println("4. Arac Ekle");
        System.out.println("Cıkıs için 5 e basınız.");
        System.out.println("Seçiminizi Giriniz: ");

    }


    public static void kiralamaIslemi(Scanner scanner, AracKiralama aracKiralama) {

        System.out.println("Arac markasını giriniz: ");
        String marka = scanner.next();
        System.out.println("Arac modelini giriniz: ");
        String model = scanner.next();


        Arac secilenArac = aracKiralama.getArac(marka, model);
        if (secilenArac != null) {



            aracKiralama.aracKiralama(secilenArac);



            System.out.println("Kiralama süresini gun turunden giriniz: ");
            int kiralamaSuresi = girisKontrol(scanner);
            if (kiralamaSuresi > 0) {
                try {
                    double kiraMaliyeti = aracKiralama.kiraUcretisHesapla(secilenArac, kiralamaSuresi);
                    System.out.println("Kiiralam islemi tamamlandi.");

                    System.out.println("Toplam kira maliyeti:" + kiraMaliyeti);
                } catch (IllegalArgumentException e) {
                    System.out.println("Hata: " + e.getMessage());
                }
            } else {
                System.out.println("Hatali gün tuslamasi yaptiniz.");
            }
        }   else{
            System.out.println("Kiralik arac bulunamadi.");
        }


    }

    public static void aracIadeIslemi(Scanner scanner, AracKiralama aracKiralama) {
        scanner.nextLine();
        System.out.println("Araç markasını giriniz: ");
        String marka = scanner.nextLine().trim();
        System.out.println("Araç modelini giriniz: ");
        String model = scanner.nextLine().trim();

        if (marka.isEmpty() || model.isEmpty()) {
            System.out.println("Marka ve model boş olamaz.");
            return;
        }

        Arac[] kiralanmisAraclar = aracKiralama.getKiralanmisAraclar();







        if (kiralanmisAraclar != null && kiralanmisAraclar.length > 0) {
            Arac iadeEdilecekArac = null;
            for (Arac arac : kiralanmisAraclar) {
                if (arac == null) {
                    continue;
                }
                if (arac.getMarka() != null && arac.getModel() != null &&
                        arac.getMarka().equalsIgnoreCase(marka) && arac.getModel().equalsIgnoreCase(model)) {
                    iadeEdilecekArac = arac;
                    break;
                }



            }

            if (iadeEdilecekArac != null) {
                try {
                    aracKiralama.aracIade(iadeEdilecekArac);
                    System.out.println("Araç başarıyla iade edildi.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Hata: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Beklenmeyen bir hata oluştu: " + e.getMessage());
                }
            } else {
                System.out.println("İade geçersiz. Araç kiralanmış veya bulunamadı.");
            }
        } else {
            System.out.println("İade geçersiz. Kiralanan araç bulunamadı.");
        }

    }





    public static void aracEklemeIslemi (Scanner scanner, AracKiralama aracKiralama){

        try {

            System.out.println("Eklemek isetdiginiz Arac Markasini Giriniz: ");
            String  marka = scanner.next();
            System.out.println("Eklemek istediginiz arac modelini giriniz: ");
            String model = scanner.next();
            System.out.println("Eklemek istediginiz arac yilini giriniz: ");
            int yil = scanner.nextInt();
            System.out.println("Eklemek istediginiz arac kira ücretini grinizç: ");
            double kiraUcreti = scanner.nextDouble();



            if (yil < 0 || kiraUcreti < 0) {
                throw new IllegalArgumentException("Yil ve kira orani neagtif olamaz.");
            }


            Arac aracekle = new Arac(marka, model, yil, kiraUcreti) {

            };

            aracKiralama.aracEkle(aracekle);
            System.out.println("Arac basarıyla eklendi.");
            aracKiralama.kiralamaBilgiGoster();//ekledim
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());


        }
    }
}
