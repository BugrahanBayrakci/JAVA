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


### STATİC

Program başlıyor → Class Loader yükler → static şeyler hafızaya alınır → program bitene kadar silinmez.

static = sınıfa ait olan, program boyunca tek olan, objeye bağlı olmayan.

Bunu şöyle düşün:
🍔 Non-static

Her oyuncuya ayrı hamburger veriliyor.

🏛 Static

Ortada tek bir pizza var, herkes ondan alıyor.

Static şeyler bir nesneye (object) ait değildir.
Class’a aittir.
Ve Java bunları program başlarken otomatik oluşturur.


Mesela static değişken oluşturursan herkeste aynı değer olur. Nesneye bağlı değil.

Bir metodu static yaparsan class ismiyle çağırabilirsin.
```java


class MathUtils {
    static void hello() {
        System.out.println("Selam kral");
    }
}

public class Main {
    public static void main(String[] args) {

        MathUtils.hello(); // OBJECT OLUŞTURMADAN çağırdık

    }
}
```
static olmassa 

```java
MathUtils m = new MathUtils();
m.hello();   // static değilse böyle çağırırsın
```

⚠️⚠️⚠️⚠️⚠️⚠️ Constructlar sadece obje oluşturulduğunda çağrıldığı için statikte class adıyla çağırdığımda construct çalışmayacak. Bunu yapmak için static yapıcı koyulması gerekmektedir. Birden fazla oluşturulabilir.

🔥 static → sınıfın metodu

🔥 non-static → nesnenin metodu

```java
class Example {
    static {
        System.out.println("Static block çalıştı!");
    }

    Example() {
        System.out.println("Constructor çalıştı!");
    }

    static void test() {
        System.out.println("Static method");
    }
}

public class Main {
    public static void main(String[] args) {
        Example.test(); // sadece static method
    }
}
```
Çıktı 

Static block çalıştı!

Static method

🔥 INNER CLASS NEDİR?
Bir sınıfın içinde tanımlanan başka bir sınıftır.
```java
class Outer {
    class Inner { }
}
```

Ana class static olamıyor onun içine yazdığın class static olabilir.

```java
class Outer {
    static int a = 5;

    static class Inner {
        void show() {
            System.out.println("a = " + a);
        }
    }
}
```
### COLLECTİONS

Java’da normal array sınırlı bir şeydi:

Boyut sabit

Insert/silme zor

### 1️⃣  ArrayList

⭐ 1. ArrayList Oluşturma

```java
import java.util.ArrayList;
public class Main {
ArrayList sayilar =new ArrayList();

}
```

Type-Safe ArrayList

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<String>();

        liste.add("Ali");
        liste.add("Veli");
        liste.add("Ayşe");
        liste.add("Ali"); // tekrar OK

        System.out.println(liste);
    }
}
```

⭐ 2. Eleman Ekleme — add()
```java
isimler.add("Ali");
isimler.add("Veli");
isimler.add("Ayşe");
```
⭐ 3. Eleman Çekme — get()
```java

System.out.println(isimler.get(0)); // Ali

⭐ 4. Eleman Değiştirme — set()
```java

isimler.set(0, "Kerem"); // Ali → Kerem oldu
```

⭐ 5. Eleman Silme — remove()
```java

isimler.remove("Veli");
isimler.remove(0);
```
⚠️ indise göre silince sola kayıyor indisler unutma


⭐ 6. Liste Boyutu — size()
```java
System.out.println(isimler.size());
```
⭐ 8. Tüm listeyi yazdırma
```java

System.out.println(isimler);
```
⭐ 9. Döngü ile gezme
```java

for (int i = 0; i < isimler.size(); i++) {
    System.out.println(isimler.get(i));
}
// foreach ile gez.

for (String isim : isimler) {
    System.out.println(isim);
}
```
⭐ 10. Temizleme
```java
isimler.clear();
```
⚠️ İndisler boş olursa hata verecek.


ArrayList Classlarla kullanmak
```java

public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```
```java

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Ahmet", 20));
        students.add(new Student("Mehmet", 22));
        students.add(new Student("Ayşe", 19));

        for (Student s : students) {
            s.showInfo();
        }
    }
}
```


### 2️⃣   HASHMAP
  Önemli indis yok anahtarla erişim var sıralı değildir


HashMap = Key → Value sistemi
⭐ 1. HashMap oluşturma
```java
HashMap<String, Integer> map = new HashMap<>();
```

String → key tipi

Integer → value tipi

⭐ 2. Eleman Ekleme — put()
```java

map.put("Ahmet", 90);
map.put("Mehmet", 75);
map.put("Ayşe", 100);
```
⭐ 3. Eleman Okuma — get()
```java

int not = map.get("Ayşe");
System.out.println(not);
```
⭐ 4. Eleman Silme — remove()
```java

map.remove("Mehmet");
```
⭐ 5. Eleman Var mı? — containsKey() / containsValue()
```java

map.containsKey("Ahmet"); // true
map.containsValue(100);   // true
```

⭐ 6. Boyut — size()
```java

System.out.println(map.size());
```

⭐ 7. Tüm Elemanları Gezmek
```java

for (String key : map.keySet()) {
    System.out.println(key + " → " + map.get(key));
}
```

### Exception Handling (Hata yönetimi)

Program çalışırken oluşan hatalara exception denir.



![s][resim3]

[resim3]: ./source/ExceptionHierarchy.PNG
```
Throwable
   |-- Exception (Checked)
         |-- RuntimeException (Unchecked)
   |-- Error (Unchecked)
 ```
✔️ Checked Exception

Derleme zamanında (compile time) kontrol edilir

Kod yazarken IDE uyarır

Örnekler: IOException, FileNotFoundException, SQLException

✔️ Unchecked Exception

Çalışma anında (runtime) oluşur

IDE uyarmaz

Örnekler: NullPointerException, ArithmeticException, IndexOutOfBoundsException


### 🔥 2) try – catch – finally
```java

try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Sıfıra bölme hatası!");
}
```

try: Riskli kod

catch: Hata olduğunda çalışır

finally: Hata olsa da olmasa da her zaman çalışır

```java

try {
    String s = null;
    System.out.println(s.length());
} catch (NullPointerException e) {
    System.out.println("Boş nesne hatası!");
} finally {
    System.out.println("Bu her zaman çalışır");
}
```

```java

try {
    int arr[] = {1, 2};
    System.out.println(arr[5]);
} catch (ArithmeticException e) {
    System.out.println("Matematik hatası");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Dizi dışı hata!");
}
```

| Yapı      | Ne işe yarar?                         |
| --------- | ------------------------------------- |
| `try`     | Riskli kod                            |
| `catch`   | Hata olunca çalışır                   |
| `finally` | Her zaman çalışır                     |
| `throw`   | Manuel hata fırlatır                  |
| `throws`  | Metodun hata fırlatabileceğini söyler |
| Checked   | Derleme zamanında zorunlu             |
| Unchecked | Runtime’da ortaya çıkar               |

###  🔥 3) throws (metodun hata atabileceğini söylemek)
```java

public void readFile() throws IOException {
    FileReader fr = new FileReader("test.txt");
}
```
throws → “Bu metot hata fırlatabilir, try-catch ile yakalayın” demektir.


🚀 THROW NEDİR?

Normalde hatayı Java atar — ama sen özel olarak hata oluşturmak istersen throw kullanırsın.

```java

public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Yaş negatif olamaz!");
    }
    this.age = age;
}
```
```java

public void withdraw(int amount) {
    if (amount > balance) {
        throw new RuntimeException("Yetersiz bakiye!");
    }

    balance -= amount;
}
```

| Konu                                    | Açıklama                     |
| --------------------------------------- | ---------------------------- |
| **throw**                               | Hemen bir hata fırlatır      |
| **throw new ...**                       | Yeni bir exception oluşturur |
| **Program o satırdan sonrası çalışmaz** | Evet durur                   |
| **Tek bir exception fırlatır**          | Birden fazla olmaz           |



### 🛠️ CUSTOM EXCEPTION OLUŞTURMA


1️⃣ class oluştur → Exception’ı extend et

```java

public class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
```
```java
public void setAge(int age) throws InvalidAgeException {

    if (age < 0) {
        throw new InvalidAgeException("Yaş negatif olamaz!");
    }

    this.age = age;
}

```

### Java Dosyalarla Çalışmak

#### 1️⃣ Dosya oluşturma

```java
   File dosya=new File("C:\\Users\\BugoR\\Documents\\GitHub\\JAVA\\files\\students.txt");
        try {
            dosya.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
```

dosya.createNewFile(); true veya false döndürüyor.

```java

File file=new File("C:\\Users\\BugoR\\Documents\\GitHub\\JAVA\\files\\students.txt");

        System.out.println("Adı: " + file.getName());
        System.out.println("Yolu: " + file.getAbsolutePath());
        System.out.println("Var mı?: " + file.exists());
        System.out.println("Boyut (byte): " + file.length());
        System.out.println("Okunabilir mi?: " + file.canRead());
        System.out.println("Yazılabilir mi?: " + file.canWrite());
        System.out.println("Bir klasör mü?: " + file.isDirectory());
```



🚀 Scanner ile Dosya Okuma

```java
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {  
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


2. yöntem.

```java

import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Path.of("data.txt"));

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
```


Dosyalara yazmak 

```java

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("Merhaba bro!\n");
            writer.write("Java dosyaya yazıyor.");
            writer.close();   // kapatmazsan yazmaz
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
✔️ Özellik:

Dosya yoksa oluşturur

Üzerine yazar (eskiyi siler)


🚀 2. FileWriter + append = true → Üzerine EKLEME

```java

FileWriter writer = new FileWriter("data.txt", true);
writer.write("Yeni satır ekledim bro\n");
writer.close();
```

```java

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write("Satır 1");
            writer.newLine();
            writer.write("Satır 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```