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



⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️

### POLYMORPHISM
![s][resim1]

[resim1]: ./source/POLYMORPHISM.png

FileLogger, EmailLogger, DatabaseLogger BaseLogger sınıfından extends ile türetilmiş.

```java
class FileLogger extends BaseLogger
```
FileLogger aslında bir BaseLogger’dır.

| Tür                                     | Geçerli mi?                                |
| --------------------------------------- | ------------------------------------------ |
| `BaseLogger logger = new FileLogger();` | ✅ Evet                                     |
| `FileLogger logger = new BaseLogger();` | ❌ Hayır (çünkü BaseLogger daha üst seviye) |

```java

BaseLogger[] loggers = new BaseLogger[] {
    new FileLogger(),
    new EmailLogger(),
    new DatabaseLogger()
};
```

Bu dizideki her eleman BaseLogger türünde davrandığı sürece, hangi alt sınıf olduğunun önemi yok
```java

for(BaseLogger logger : loggers) {
    logger.log("Hello");
}
```
✔ "Sen aslında bir FileLogger'sın → FileLogger.log() çalıştırayım."

✔ "Sen EmailLogger'sın → EmailLogger.log() çalıştırayım."

✔ "Sen DatabaseLogger'sın → DatabaseLogger.log() çalıştırayım."

![s][resim2]

[resim2]: ./source/POLYMORPHISMCİKTİ.png


Şimdi base içinde bir metot yazdın sonra extends alan başka classlarda aynı isimde metot yazarsan basede olan değilde özel olarak extends eden çalışır. Final yazarsan override olmayacak.


## ABSTRACT CLASS

1️⃣ Ortak bir temel yapı sağlamak (kalıp oluşturmak)

Bir grup sınıfın ortak özellikleri varsa, bunları abstract class içinde toplarsın.

Örnek:

Kadın oyuncu

Erkek oyuncu

Çocuk oyuncu

2️⃣ Alt sınıflara “bu metodu kesin yazacaksın” zorunluluğu koymak
```java

public abstract class GameCalculator {
    public abstract void hesapla(); // alt sınıf bunu yazmak zorunda belirli bir kalıp oluşturduk.
}


```
2️⃣ Bazı metodları zorunlu kılmak


Abstract class obje oluşturulamaz.

```java
GameCalculator calc = new GameCalculator(); // ❌
```
Abstract class'lar:

✔ Gövdeli metod içerir → ortak kod.

✔ Gövdesiz metod (abstract) içerir → zorunlu metod.

✔ Değişken ve constructor içerir.

✔ Inheritance kullanır amacı budur zaten.



| Özellik               | Abstract Class                    | Interface                                        |
| --------------------- | --------------------------------- | ------------------------------------------------ |
| Abstract metod        | ✔️                                | ✔️                                               |
| Gövdeli metod         | ✔️                                | ✔️ (default ile, ama sınırlı)                    |
| Constructor           | ✔️                                | ❌                                                |
| Değişken / alan tutma | ✔️                                | ❌ (sadece sabit public static final değişkenler) |
| Kalıtım               | 1 tane extend edilebilir          | Birden fazla interface implement edilebilir      |
| Amaç                  | Ortak temel yapı + kısmi davranış | Sadece davranış sözleşmesi                       |
| Obje oluşturulabilir  | ❌                                 | ❌                                                |

Abstract class = hem ortak kod hem zorunlu metodlar.

Interface = sadece kurallar (sözleşme), çoklu kalıtım.