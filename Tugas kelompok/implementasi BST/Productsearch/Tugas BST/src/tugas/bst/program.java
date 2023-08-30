package tugas.bst;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

import static tugas.bst.datakaryawan.totalGaji;
import static tugas.bst.middlestring.middle;


public class program extends Node{
    Node root;
    public program(){
        root = null;
    }
    
    public void insert(Node input) {
         Node temp = input;
         temp.leftchild = null;
         temp.rightchild = null;
         if (root == null) root = temp;
         else {
             Node q = root;
             Node p = root;
             while (q != null) {
                 p = q;
                 if (input.nip < p.nip) q = p.leftchild;
                 else if (input.nip > p.nip) q = p.rightchild;
                 else q = null;
             }
             if (input.nip < p.nip) p.leftchild = temp;
             else if (input.nip > p.nip) p.rightchild = temp;
         }
     }
    
    public int deletecb(int x){
         int gaji_temp=0;
        if(root!=null) {
            Node q=root,p=q,r=p;
            while (q!=null && x!=p.nip) {
                r=p;p=q;
                if(x<p.nip) q=p.leftchild;
                else if(x>p.nip) q=p.rightchild;
                else q=null;
            }
            if ((x==p.nip) && (p.leftchild==null && p.rightchild==null)){
                if (x<r.nip) {r.leftchild.gaji=gaji_temp; r.leftchild=null; return gaji_temp;}
                else {r.rightchild.gaji=gaji_temp; r.rightchild=null; return gaji_temp;}
            }
            else System.out.println("Data not Found"); return 0;
        }
        return 0;
    }
    
    public boolean find(int x){
        if(root!=null) {
            Node q=root; Node p;
            while (q!=null && q.nip!=x) {
                p=q;
                if(x<p.nip) q=p.leftchild;
                else if(x>p.nip) q=p.rightchild;
            }
            System.out.println("NIP ditemukan, berikut data karyawan : ");
            System.out.println("Nama       : "+q.name);
            System.out.println("NIP        : "+q.nip);
            System.out.println("Masa Kerja : "+q.masa_kerja);
            System.out.println("Gaji       : "+q.gaji);
            return true;
        }
        return false;
    }
    
    void inorder(Node x){
        if (x!=null) {
            inorder(x.leftchild);
            Node y = x;
            String a = String.valueOf(y.nip);
            String b = String.valueOf(y.masa_kerja);
            String c = y.name;
            System.out.println("|" + middle(10, a) + "|" + middle(30, c) + "|" + middle(10, b) + "|\t " + y.gaji + "   |");
            inorder(x.rightchild);
        }
    }

    public boolean update(int x){
        if(root!=null) {
            Node q=root; Node p;
            while (q!=null && q.nip!=x) {
                p=q;
                if(x<p.nip) q=p.leftchild;
                else if(x>p.nip) q=p.rightchild;
            }
            System.out.println("Gaji awal "+q.name+" : "+q.gaji);
            System.out.println("Gaji "+q.name+" yang baru : ");
            Scanner sc = new Scanner(System.in);
            int uptd = sc.nextInt();
            totalGaji-=q.gaji;
            q.gaji = uptd;
            totalGaji+=q.gaji;
            System.out.println("Gaji telah di update menjadi "+q.gaji);
            return true;
        }
        return false;
    }

    public boolean uptdMasaKerja(int x){
        if(root!=null) {
            Node q=root; Node p;
            while (q!=null && q.nip!=x) {
                p=q;
                if(x<p.nip) q=p.leftchild;
                else if(x>p.nip) q=p.rightchild;
            }
            System.out.println("Masukkan masa kerja "+q.name+" yang baru : ");
            Scanner sc = new Scanner(System.in);
            int masaKerjaBaru = sc.nextInt();
            q.masa_kerja = masaKerjaBaru;
            return true;
        }
        return false;
    }

    public String inOrderFileWrite(Node x){
         if (x!=null) {
             try {
                 inOrderFileWrite(x.leftchild);
                 String a = String.valueOf(x.nip);
                 String b = String.valueOf(x.masa_kerja);
                 String c = "|" + middle(10, a) + "|" + middle(30, x.name) + "|" + middle(10, b) + "|\t " + x.gaji + "   |";
                 FileWriter fw = new FileWriter("info.txt",true); //the true will append the new data
                 fw.write(c+"\n");//appends the string to the file
                 fw.close();
                 inOrderFileWrite(x.rightchild);

             } catch (IOException e){
                 System.out.println("Error");
             }
         }
         return "";
    }

}
