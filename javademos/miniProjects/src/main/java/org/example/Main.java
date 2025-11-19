package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Sayi giriniz :");
        int  sayi = sc.nextInt();
        boolean sayiAsalmi=false;

        for(int i=2;i<sayi;i++) {



            if (sayiAsalmi == false) {
                break  ;
            }
            else{
                switch (sayi % i) {
                    case 0:
                        sayiAsalmi = false;
                        break;
                    default:
                        sayiAsalmi = true;

                }
                }

        }
        if(sayiAsalmi==false){
            System.out.println("Sayiniz değil");
        }
        else{
            System.out.println("Sayiniz asal");

        }






    }
}
