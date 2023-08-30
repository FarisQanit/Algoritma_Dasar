package tugas.bst;
import java.io.IOException;
import java.util.Scanner;

public class Interfacedata {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean done=false;
        datakaryawan.open();
        do {
            System.out.println("\nDaftar Menu :\n1. Insert()\n2. Delete()\n3. Find()\n4. Display()\n5. UpdateGaji()\n6. UpdateMasaKerja()\n7. GetTotalGaji()\n8. Keluar()");
            System.out.print("Masukkan pilihan : ");
            int n = sc.nextInt();
            switch (n){
                case 1:datakaryawan.insert();break;
                case 2:datakaryawan.delet();break;
                case 3:datakaryawan.find();break;
                case 4:datakaryawan.display();break;
                case 5:datakaryawan.updateGaji();break;
                case 6:datakaryawan.updateMasaKerja();break;
                case 7:datakaryawan.Gajitotal();break;
                case 8:{
                    datakaryawan.close();
                    System.out.println("Terimakasih :)");
                    done = true;
                } break;
                default:System.out.println("Perintah tidak tersedia, harap memasukkan angka 1-8");
            }
        } while (!done);
    }
}
