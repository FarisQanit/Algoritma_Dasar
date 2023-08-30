package Productsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static Productsearch.middlestring.middle;

public class listproduk extends mainproduct{
     public String nama;
    public int proID,jumlahbarang,hproduk;
    public static int nElems, totalGaji=0;
    public static boolean found = true;
    public static mainproduct K = new mainproduct();

    public static void open(){
        File fileinput = new File("data.txt");
        int num=0;
        try{
            Scanner scanfile = new Scanner(fileinput);
            while (scanfile.hasNextLine()){
                Node data = new Node();
                data.name = scanfile.nextLine();
                data.proID = Integer.valueOf(scanfile.nextLine());
                data.jumlah = Integer.valueOf(scanfile.nextLine());
                data.hpro = Integer.valueOf(scanfile.nextLine());
                K.insert(data);num++;
            }
            nElems = num;
        }
        catch (FileNotFoundException error){
            System.out.println("File not found");
        }
    }

   


    public static void find(){
        found=true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan ID produk dicari : ");
        int key = sc.nextInt();
        found= K.find(key);
        if (!found) System.out.println("Produk tidak ditemukan");
    }

    public static void display() {
        System.out.println(" _____________________________________________________________");
        System.out.println("|" + middle(10, "ProdukID") + "|" + middle(30, "Nama") + "|"+ middle (10, "Jumlah")+"|" + middle(8, "Harga per item")+"|");
        System.out.println("|__________|______________________________|__________|________|");
        K.inorder(K.root);
    }


    public static void close() throws IOException {
        try{
            FileWriter File = new FileWriter("info.txt");
            File.write(" _____________________________________________________________\n");
            File.write("|" + middle(10, "ProdukID") + "|" + middle(30, "Nama") + "|"+ middle (10, "Jumlah")+"|" + middle(8, "Harga per item")+"|");
            File.write("|__________|______________________________|__________|________|\n");
            K.inOrderFileWrite(K.root);
        } catch (IOException e){
            System.out.println("Gagal membuat berkas");
        }
    }
    
}
