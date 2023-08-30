package Productsearch;
import java.io.IOException;
import java.util.Scanner;

public class mainmenu {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean done=false;
        listproduk.open();
        do {
            System.out.println("\nDaftar Menu :\n1. Find()\n2. Display()\n3. Keluar()");
            System.out.print("Masukkan pilihan : ");
            int n = sc.nextInt();
            switch (n){
                case 1:listproduk.find();break;
                case 2:listproduk.display();break;
                case 3:{
                    listproduk.close();
                    System.out.println("Terimakasih telah memakai jasa kami :)");
                    done = true;
                } break;
                default:System.out.println("Perintah tidak tersedia, harap memasukkan angka 1-3");
            }
        } while (!done);
    }
}
