package org.example;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        dosyaOlustur();

        dosyaBilgileriniYazdir();

    }

    public static void dosyaOlustur(){

        File dosya=new File("C:\\Users\\BugoR\\Documents\\GitHub\\JAVA\\files\\students.txt");
        try {
            dosya.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void dosyaBilgileriniYazdir(){

        File file=new File("C:\\Users\\BugoR\\Documents\\GitHub\\JAVA\\files\\students.txt");

        System.out.println("Adı: " + file.getName());
        System.out.println("Yolu: " + file.getAbsolutePath());
        System.out.println("Var mı?: " + file.exists());
        System.out.println("Boyut (byte): " + file.length());
        System.out.println("Okunabilir mi?: " + file.canRead());
        System.out.println("Yazılabilir mi?: " + file.canWrite());
        System.out.println("Bir klasör mü?: " + file.isDirectory());

    }

}
