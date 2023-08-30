package tugas.bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static tugas.bst.middlestring.middle;

public class datakaryawan extends program{
     public String nama;
    public int nip,masaKerja,gaji;
    public static int nElems, totalGaji=0;
    public static boolean found = true;
    public static program L = new program();

    public static void open(){
        File fileinput = new File("data.txt");
        int num=0;
        try{
            Scanner scanfile = new Scanner(fileinput);
            while (scanfile.hasNextLine()){
                Node data = new Node();
                data.name = scanfile.nextLine();
                data.nip = Integer.valueOf(scanfile.nextLine());
                data.masa_kerja = Integer.valueOf(scanfile.nextLine());
                data.gaji = Integer.valueOf(scanfile.nextLine());
                L.insert(data);num++;
                totalGaji+= data.gaji;
            }
            nElems = num;
        }
        catch (FileNotFoundException error){
            System.out.println("File not found");
        }
    }

    public static void insert(){
        Node a = new Node();
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan data yang ingin diinput :");
        System.out.print("Masukkan NIP        : ");
        a.nip=Integer.valueOf(sc.nextLine());
        System.out.print("Masukkan nama       : ");
        a.name=sc.nextLine();
        System.out.print("Masukkan masa kerja : ");
        a.masa_kerja=Integer.valueOf(sc.nextLine());
        System.out.print("Masukkan gaji       : ");
        a.gaji=Integer.valueOf(sc.nextLine());
        totalGaji+=a.gaji;
        L.insert(a);
        nElems++;
    }

    public static void delet(){
        found=true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan NIP karyawan yang ingin dihapus : ");
        int key = sc.nextInt();
        totalGaji-= L.deletecb(key);
    }

    public static void find(){
        found=true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan NIP karyawan yang ingin dicari : ");
        int key = sc.nextInt();
        found= L.find(key);
        if (!found) System.out.println("NIP tidak ditemukan");
    }

    public static void display() {
        System.out.println(" _____________________________________________________________");
        System.out.println("|" + middle(10, "NIP") + "|" + middle(30, "Nama") + "|"+ middle (10, "Masa Kerja")+"|" + middle(8, "Gaji")+"|");
        System.out.println("|__________|______________________________|__________|________|");
        L.inorder(L.root);
    }

    public static void updateGaji(){
        found=true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan NIP karyawan yang gajinya akan diperbarui : ");
        int key = sc.nextInt();
        L.update(key);
        if(!found) System.out.println("NIP tidak ditemukan");
    }

    public static void updateMasaKerja(){
        found = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan NIP karyawan yang masa kerjanya akan diperbarui : ");
        int key = sc.nextInt();
        L.uptdMasaKerja(key);
        if (!found) System.out.println("NIP tidak ditemukan");
    }

    public static void Gajitotal(){
        System.out.println("Total gaji seluruh karyawan = "+totalGaji);
    }

    public static void close() throws IOException {
        try{
            FileWriter File = new FileWriter("info.txt");
            File.write(" _____________________________________________________________\n");
            File.write("|" + middle(10, "NIP") + "|" + middle(30, "Nama") + "|"+ middle (10, "Masa Kerja")+"|" + middle(8, "Gaji")+"|\n");
            File.write("|__________|______________________________|__________|________|\n");
            L.inOrderFileWrite(L.root);
        } catch (IOException e){
            System.out.println("Gagal membuat berkas");
        }
    }
    
}
