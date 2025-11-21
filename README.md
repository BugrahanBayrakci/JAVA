# JAVA

### Java Variable Arguments (Varargs)


Java'da Varargs (Variable Arguments), bir metoda istediğin kadar argüman gönderme imkânı sağlar.
Bu özellik sayesinde aynı türden değişken sayıda parametre alan metotlar yazmak kolaylaşır.

```java
donusTipi metodAdi(Tip... degiskenAdi)
```

... üç nokta işareti, varargs yapısını ifade eder.

Metoda 0, 1 veya daha fazla parametre gönderilebilir.

Metot içinde varargs bir dizi gibi davranır.

```java

public static int topla(int... sayilar) {
    int toplam = 0;
    for (int s : sayilar) {
        toplam += s;
    }
    return toplam;
}

public static void main(String[] args) {
    System.out.println(topla(1, 2, 3));        // 6
    System.out.println(topla(10, 20));         // 30
    System.out.println(topla());               // 0
}
```

Aslında diziye çeviriyor bu.

System.out.println(topla2());
// herhangi bir değer döndürmessen 0 olur.


### STACK ve HEAP Nedir? (Java için)



1) STACK (küçük, hızlı alan)

Metodların çalıştığı yer

Yerel değişkenler burada durur

Primitive (int, double, boolean…) değerler burada tutulur

Referansların kendisi burada tutulur

2) HEAP (büyük, yavaş alan)

new ile oluşturduğun tüm nesneler burada yaşar

Class’tan oluşturulan objeler burada durur

Garbage Collector bu alanı temizler.

![s][resim]

[resim]: ./source/Ekran%20Alıntısı.PNG


 ## Referance TYPE⚠️⚠️⚠️
```java
int[] sayilar1 = new int[]{1, 2, 3};
int[] sayilar2 = new int[]{4, 5, 6};
sayilar2 = sayilar1;
sayilar1[0] = 10;
System.out.println(sayilar2[0]);
```


1) Başlangıçta iki ayrı dizi oluşuyor. Bu iki dizi farklı yerlerde bellekte duruyor.
2) sayilar2 = sayilar1; Bu satır diziyi kopyalamaz!
→ sayilar2 artık sayilar1'in tuttuğu diziyi göstermeye başlar.(Bellek bölgesini). Artık ortada tek bir dizi var, iki isim var.
3) sayilar1[0] = 10; Bu satır o ortak dizinin ilk elemanını değiştirir: Ve iki değişken de bunu görür: