


public class AracKiralama {
    private Arac[] kullanilabilirAraclar = new Arac[100];
    private Arac[] kiralanmisAraclar = new Arac[100];
    private int kullanilabilirSayisi = 0;
    private int kiralanmisSayisi = 0;

    public AracKiralama(){

        kullanilabilirAraclar=new Arac[100];
        kiralanmisAraclar=new Arac[100];
        kullanilabilirSayisi=0;
        kiralanmisSayisi=0;
    }



    public void aracEkle(Arac arac) {

            this.kullanilabilirAraclar[this.kullanilabilirSayisi++] = arac;
    }
    public Arac[] getKullanilabilirAraclar() {
        return this.kullanilabilirAraclar;
    }

    public Arac[] getKiralanmisAraclar() {

        return this.kiralanmisAraclar;
    }

    public void aracKiralama(Arac arac) {
        for (int i = 0; i < this.kullanilabilirSayisi; i++) {
            if (this.kullanilabilirAraclar[i].equals(arac)) {
                if (this.kiralanmisSayisi < 100) {
                    this.kiralanmisAraclar[this.kiralanmisSayisi++] = arac;
                    this.kullanilabilirAraclar[i] = this.kullanilabilirAraclar[this.kullanilabilirSayisi--];
                    this.kullanilabilirAraclar[this.kullanilabilirSayisi] = null;





                    return;
                } else {
                    System.out.println("kiralanmis araclar doldu");
                }
            }

        }
        System.out.println("arac bulunamadi..");
    }

    public void aracIade(Arac arac) {
        if (arac == null) {
            System.out.println("Gecersiz arac.");
        } else {
            boolean aracBulundu = false;

            for(int i = 0; i < this.kiralanmisSayisi; i++) {
                if (this.kiralanmisAraclar[i].equals(arac)) {
                    if (this.kullanilabilirSayisi < 100) {
                        this.kullanilabilirAraclar[this.kullanilabilirSayisi++] = arac;
                        this.kiralanmisAraclar[i] = this.kiralanmisAraclar[this.kiralanmisSayisi--];
                        this.kiralanmisAraclar[this.kiralanmisSayisi] = null;
                        System.out.println(arac.getMarka() + " " + arac.getModel() + " iade edildi.");
                        aracBulundu = true;
                        break;
                    } else {
                        System.out.println("kullanilabilir araclar doldu.");
                    }
                }
            }

            if (!aracBulundu)  {
                System.out.println("Arac kiralanmamis veya gecersiz arac.");
            }

        }
    }



public void kiralamaBilgiGoster() {
    System.out.println("Toplam kullanılabilir araç sayısı: " + kullanilabilirSayisi);
    System.out.println("Toplam kiralanmış araç sayısı: " + kiralanmisSayisi);
}

    public void kiralamaBilgiGoster(String aracTuru) {
        int sayac = 0;
        for (int i = 0; i < kullanilabilirSayisi; i++) {
            if (kullanilabilirAraclar[i].getClass().getSimpleName().equalsIgnoreCase(aracTuru)) {
                sayac++;
            }
        }
        System.out.println(aracTuru + " türünde kullanılabilir araç sayısı: " + sayac);

    }

    public void kiralamaBilgiGoster(int yil) {
        System.out.println("Yıl bilgisi girilen araçlar: ");
        for (int i = 0; i < kullanilabilirSayisi; i++) {
            if (kullanilabilirAraclar[i].getYil() == yil) {
                kullanilabilirAraclar[i].bilgileriGoster();
            }
        }
    }
        public void kiralamaBilgiGoster(String aracTuru, int yil) {
            System.out.println(yil + " yılına ait " + aracTuru + " türündeki kullanılabilir araçlar:");
            boolean aracBulundu = false;
            for (int i = 0; i < kullanilabilirSayisi; i++) {
                if (kullanilabilirAraclar[i].getClass().getSimpleName().equalsIgnoreCase(aracTuru) &&
                        kullanilabilirAraclar[i].getYil() == yil) {
                    kullanilabilirAraclar[i].bilgileriGoster();
                    aracBulundu = true;
                }
            }
            if (!aracBulundu) {
                System.out.println("Belirtilen kriterlere uygun araç bulunamadı.");
            }
        }


    public double kiraUcretisHesapla(Arac arac, int kiraSuresi) {
        double kiraUcreti = arac.getKiraUcreti();
        return kiraUcreti * kiraSuresi;

    }


    public Otomobil[] getKullanilabilirOtomobiller() {
        Otomobil[] kullanilabilirotomobiller = new Otomobil[this.kullanilabilirSayisi];
        int otomobilIndex = 0;

        for(int i = 0; i < this.kullanilabilirSayisi; ++i) {
            if (this.kullanilabilirAraclar[i] instanceof Otomobil) {
                kullanilabilirotomobiller[otomobilIndex++] = (Otomobil)this.kullanilabilirAraclar[i];
            }
        }

        return kullanilabilirotomobiller;
    }

    public Arac getArac(String marka, String model) {
        for(int i = 0; i < this.kullanilabilirSayisi; ++i) {
            Arac mevcutArac = this.kullanilabilirAraclar[i];
            if (mevcutArac.getMarka().equals(marka) && mevcutArac.getModel().equals(model)) {
                return mevcutArac;
            }
        }

        return null;
    }




}
