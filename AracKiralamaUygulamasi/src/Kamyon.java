

public class Kamyon extends Arac {
    private String yukTipi;
    private int yukKapasitesi;
    private int tekerSayisi;

    public Kamyon(String marka, String model, int yil, double kiraUcreti, String yukTipi, int yukKapasitesi, int tekerSayisi) {
        super(marka, model, yil, kiraUcreti);
        this.yukTipi = yukTipi;
        this.yukKapasitesi = yukKapasitesi;
        this.tekerSayisi = tekerSayisi;
    }

    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Yuk Tipi: " + this.yukTipi);
        System.out.println("Yuk Kapasitesi: " + this.yukKapasitesi);
        System.out.println("Teker Sayisi: " + this.tekerSayisi);
    }




    public String getYukTipi() {
        return yukTipi;
    }

    public void setYukTipi(String yukTipi) {
        this.yukTipi = yukTipi;
    }

    public int getYukKapasitesi() {
        return yukKapasitesi;
    }

    public void setYukKapasitesi(int yukKapasitesi) {
        this.yukKapasitesi = yukKapasitesi;
    }

    public int getTekerSayisi() {
        return tekerSayisi;
    }

    public void setTekerSayisi(int tekerSayisi) {
        this.tekerSayisi = tekerSayisi;
    }









}





























