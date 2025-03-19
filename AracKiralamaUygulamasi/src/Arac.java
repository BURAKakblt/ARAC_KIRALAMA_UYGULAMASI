public abstract class Arac {
    private String marka;
    private String model;
    private int yil;
    private double kiraUcreti;
    private boolean kiralandiMi;



    public Arac(String marka, String model, int yil, double kiraUcreti ) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.kiraUcreti = kiraUcreti;
        this.kiralandiMi = false;


    }

    public void bilgileriGoster() {

        System.out.println("Aracin Markasi: " +marka );
        System.out.println("Aracin Modeli: " + model);
        System.out.println("Aracin Yili: " + yil);
        System.out.println("Aracin Kira Ucreti: " + kiraUcreti);
        System.out.println("Durumu: " + (kiralandiMi ? "Kiralandi mi" : "Kiralik"));

    }


    public String getMarka() {

        return this.marka;
    }

    public String getModel() {

        return this.model;
    }

    public int getYil() {
        return yil;
    }

    public double getKiraUcreti() {
        return this.kiraUcreti;
    }

    public boolean isKiralandiMi(boolean b) {
        return this.kiralandiMi;
    }

    public void setKiralandiMi(boolean kiralandiMi) {
        this.kiralandiMi = kiralandiMi;
    }


}
