package org.example;


class bugor{

}
public class Main {


    static void main() {

        System.out.println("Calistir");
        yazdir yazdir1=new yazdir();

        yazdir1.ekranayazdir();

        int [] dizi1={1,2,3,4};
        int [] dizi2={5,6,7,8};// Referance typetır diziler.

        dizi2=dizi1;
        dizi1[1]=10;
        System.out.println(dizi2[1]);



}}

