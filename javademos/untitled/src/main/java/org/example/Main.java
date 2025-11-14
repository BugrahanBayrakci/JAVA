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




    }
}
