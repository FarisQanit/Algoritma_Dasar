package Productsearch;

import java.util.Arrays;

public class middlestring {
    public static String middle(int lebar, String string) {
        if (string!=null) {
            int panjang = string.length();
            if (lebar < panjang)
                return (string);
            else {
                int diff = lebar - panjang;
                int l = diff / 2;
                int r = diff - l;
                char[] sebelum = new char[l];
                char[] setelah = new char[r];
                Arrays.fill(sebelum, ' ');
                Arrays.fill(setelah, ' ');
                return (new String(sebelum) + string + new String(setelah));
            }
        }
        return " ";
    }
}
