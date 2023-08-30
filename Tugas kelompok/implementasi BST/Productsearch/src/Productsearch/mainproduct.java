package Productsearch;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

import static Productsearch.middlestring.middle;


public class mainproduct extends Node{
    Node root;
    public mainproduct(){
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
                 if (input.proID < p.proID) q = p.leftchild;
                 else if (input.proID > p.proID) q = p.rightchild;
                 else q = null;
             }
             if (input.proID < p.proID) p.leftchild = temp;
             else if (input.proID > p.proID) p.rightchild = temp;
         }
     }
    
    
    public boolean find(int x){
        if(root!=null) {
            Node q=root; Node p;
            while (q!=null && q.proID!=x) {
                p=q;
                if(x<p.proID) q=p.leftchild;
                else if(x>p.proID) q=p.rightchild;
            }
            System.out.println("produk ditemukan : ");
            System.out.println("Nama       : "+q.name);
            System.out.println("Kode        : "+q.proID);
            System.out.println("Jumlah produk : "+q.jumlah);
            System.out.println("harga per item       : "+q.hpro);
            System.out.println("harga total      : "+q.hpro*+q.jumlah);
            return true;
        }
        return false;
    }
    
    void inorder(Node x){
        if (x!=null) {
            inorder(x.leftchild);
            Node y = x;
            String a = String.valueOf(y.proID);
            String b = String.valueOf(y.jumlah);
            String c = y.name;
            System.out.println("|" + middle(10, a) + "|" + middle(30, c) + "|" + middle(10, b) + "|\t " + y.jumlah + "   |");
            inorder(x.rightchild);
        }
    }


    public String inOrderFileWrite(Node x){
         if (x!=null) {
             try {
                 inOrderFileWrite(x.leftchild);
                 String a = String.valueOf(x.proID);
                 String b = String.valueOf(x.jumlah);
                 String c = "|" + middle(10, a) + "|" + middle(30, x.name) + "|" + middle(10, b) + "|\t " + x.jumlah + "   |";
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
