package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void selam() {
        System.out.println("Selam bro");
    }
    public static int topla(int a, int b) {
        return a + b;
    }

    public static int topla2(int... sayilar) {
        int toplam = 0;
        for (int s : sayilar) {
            toplam += s;
        }
        return toplam;
    }

    static void main() {
        int sonuc = topla(5, 8);
        System.out.println(sonuc);

        System.out.println(topla2(1, 2, 3));        // 6
        System.out.println(topla2(10, 20));         // 30
        System.out.println(topla2());


        selam();

    }
}
