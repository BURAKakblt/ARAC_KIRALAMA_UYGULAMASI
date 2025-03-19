public class AraziAraci extends Arac {
    private int kacCeker;
    private int kapasitesi;

    public AraziAraci(String marka, String model, int yil, double kiraUcreti, int kacCeker, int kapasitesi) {
        super(marka, model, yil, kiraUcreti);
        this.kacCeker = kacCeker;
        this.kapasitesi = kapasitesi;
    }

    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Kac Cekisli: " + kacCeker);
        System.out.println("Yolcu Kapasitesi: " + kapasitesi);
    }

    public int getKacCeker() {
        return kacCeker;
    }

    public void setKacCeker(int kacCeker) {
        this.kacCeker = kacCeker;
    }

    public int getKapasitesi() {
        return kapasitesi;
    }

    public void setKapasitesi(int kapasitesi) {
        this.kapasitesi = kapasitesi;
    }
}