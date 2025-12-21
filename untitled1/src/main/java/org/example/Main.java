package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int topla(int... sayilar) {
        int toplam = 0;
        for (int s : sayilar) {
            toplam += s;
        }
        return toplam;
    }
    static void main() {

        System.out.println(topla(1, 2, 3));        // 6
        System.out.println(topla(10, 20));         // 30
        System.out.println(topla());               // 0

        System.out.println("Parametresiz gönderim "+topla());


    }
}
