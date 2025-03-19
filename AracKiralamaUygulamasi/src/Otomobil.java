public class Otomobil extends Arac {
    private int kapiSayisi;
    private String yakitTuru;

    public Otomobil(String marka, String model, int yil, double kiraUcreti, int kapiSayisi, String yakitTuru ) {
        super(marka, model, yil, kiraUcreti);
        this.kapiSayisi = kapiSayisi;
        this.yakitTuru = yakitTuru;
    }


    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Kapi Sayisi: " + kapiSayisi);
        System.out.println("Yakit Turu: " + yakitTuru);
    }

    public int getKapiSayisi() {
        return kapiSayisi;
    }

    public void setKapiSayisi(int kapiSayisi) {
        this.kapiSayisi = kapiSayisi;
    }

    public String getYakitTuru() {
        return yakitTuru;
    }

    public void setYakitTuru(String yakitTuru) {
        this.yakitTuru = yakitTuru;
    }
}







