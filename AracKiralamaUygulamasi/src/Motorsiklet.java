import java.util.Scanner;

public class Motorsiklet extends Arac {


    public Motorsiklet(String marka, String model, int yil, double kiraUcreti ) {
        super(marka, model, yil, kiraUcreti);

    }

    public void bilgileriGoster() {
        super.bilgileriGoster();
        Scanner scanner = new Scanner(System.in);
    }

    static class yarisMotorsikleti extends Motorsiklet{


        public yarisMotorsikleti(String marka, String model, int yil, double kiraUcreti ) {
            super(marka, model, yil, kiraUcreti);
        }

        public void bilgileriGoster() {
            super.bilgileriGoster();
        }


    }

    static class dagMotorsikleti extends Motorsiklet{


        public dagMotorsikleti(String marka, String model, int yil, double kiraUcreti ) {
            super(marka, model, yil, kiraUcreti);
        }

        @Override
        public void bilgileriGoster() {
            super.bilgileriGoster();
        }

    }
}


