import java.util.Scanner;

public class turak {
    public static void main(String[] args) {
        String[] arr={"1.personel","2.Satıslar","3.Krediler","0.Çıkıs"};
        Scanner girdi = new Scanner(System.in);
        for (String x:arr){
            System.out.println(x);
        }
        int sonuc = girdi.nextInt();
        switch (sonuc) {
            case 1:
                System.out.printf("personel seçildi");
            case 2:
                System.out.printf("satışlar seçildi");
            case 3:
                System.out.printf("krediler seçildi");
            case 0:
                System.exit(1);
        }

    }
}
