package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Scanner sc=new Scanner(System.in);

        System.out.println("Sayiyi giriniz");
        int toplam=0;

        int sayi= sc.nextInt();

        if(sayi>0){
            for(int i=1;i<sayi;i++){
                if(sayi%i==0){
                    toplam=toplam+i;
                }

            }

            if(sayi==toplam){
                System.out.println("Sayi Mükemmeldir.");
            }
            else {
                System.out.println("Sayi Mükemmel Değil.");
            }

        }




    }
}
