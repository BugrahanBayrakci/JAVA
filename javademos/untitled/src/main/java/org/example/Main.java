package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        System.out.println("Merhaba Java!");
        String isim = "bugor";
        System.out.println(isim);
        char harf= 'd';
        System.out.println(harf);
        System.out.println("----------------------------------");
        int a = 5;
        int b = 7;

        System.out.println("a+b = " +a + b); // 8
        System.out.println(a - b); // 2
        System.out.println(a * b); // 15
        System.out.println(a / b); // 1
        System.out.println(a % b); // 2
        System.out.println("----------------------------------");

        if(a>b){

            System.out.println("a>b");
        }
        else if(b>a) {
            System.out.println("b>a");

        }
        System.out.println("----------------------------------");

        int gun = 3;

        switch (gun) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.println("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
            default:
                System.out.println("Geçersiz gün");
        }


        System.out.println("----------------------------------");

        String Kullanici= "admin";

        switch(Kullanici){
            case("admin"):
                System.out.println("Kullanici Admin");
                break;// break yazmassan aşşağısındakilerde çalışır
            case("Bugor"):
                System.out.println("Kullanici Bugor");
                break;


        }

        System.out.println("----------------------------------");
        int sayi=10;
        do{
            System.out.println(sayi);//en az bir sefer çalışıyor.
        }while (sayi<10);

        System.out.println("----------------------------------");
        //DİZİ OLUŞTURMA 1


        int [] dizi=new int[3];

        dizi[0] = 1;
        dizi[1] = 2;
        dizi[2] = 3;

        //DİZİ OLUŞTURMA 2

        int[] dizi2 = {1, 2, 3, 4, 5};

        //ERİŞİM 1
        for (int i : dizi) {
            System.out.println(i);
        }
        //ERİŞİM2
        for(int i=0;i<4;i++){
            System.out.println(dizi2[i]);
        }
        //2 Boyutlu dizi 1
        int [] [] sayiliste=new int[3][3];


        for (int i = 0; i < sayiliste.length; i++) {          // satır
            for (int j = 0; j < sayiliste[i].length; j++) {   // sütun
                System.out.print(sayiliste[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");

        int[][] sayilar3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0; i < sayilar3.length; i++) {          // satır
            for (int j = 0; j < sayilar3[i].length; j++) {   // sütun
                System.out.print(sayilar3[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------STRING İSLEMLERİ------------------");


        String ad = "Ahmet";
        System.out.println("Number of character: "+ad.length()); // karakter sayısı

        String s = "Java";
        System.out.println("Number of 0 character : "+s.charAt(0)); // J

        String merhaba = "Merhaba";
        System.out.println("Characters 0-3"+merhaba.substring(0, 3)); // Mer
        System.out.println("Character 3-"+merhaba.substring(3));    // haba

        System.out.println("String start with mer: "+merhaba.startsWith("Mer")); // true
        System.out.println("String end with mer:"+merhaba.endsWith("ba"));    // true

        System.out.println("index of the first letter a: "+merhaba.indexOf("a"));
        System.out.println("index of the last letter a: "+merhaba.lastIndexOf("a"));

        System.out.println("Araba".replace("a", "x"));  // Arxbx harfleri değiştirme

        String cumle = "Ben Java öğreniyorum";
// split isteninlen regexe göre kelimelere ayır.
        for (String kelime : cumle.split(" ")){
            System.out.println(kelime);

        }

        s.toUpperCase();  // MERHABA
        s.toLowerCase();  // merhaba

// Başındaki ve sonundaki boşlukları siler
        String trimkelene = "   Merhaba Dünya   ";
        System.out.println(trimkelene.trim());















    }
}
