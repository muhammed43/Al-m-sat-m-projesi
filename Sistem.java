import java.util.ArrayList;
import java.util.Scanner;

public class Sistem {
    
    public static void main(String[] args) {
        
        //sistem kayitli kullanici ve saticilar burada tutulur
        ArrayList<Satici> saticilar = new ArrayList<>();
        ArrayList<Alici> alicilar = new ArrayList<>();

        //saticilar eklenir
        saticilar.add(new Satici("Ali","Taskin","ali","123","11111111111","3432432","ali@gmail.com","adres"));
        saticilar.add(new Satici("Sema","Katil","sema","1234","11111111111","24324343","sema@gmail.com","adres1"));
        saticilar.add(new Satici("Hasan","Tas","hasan","1234","11111111111","14432432","hasan@gmail.com","adres3"));

        //saticilara urunler eklenir
        saticilar.get(0).urunEkle("Bugday",2,100);
        saticilar.get(0).urunEkle("Un",2.5,90);
        saticilar.get(1).urunEkle("Bugday",3,50);
        saticilar.get(2).urunEkle("Bugday",4,75);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n---- SISTEM ACILDI ----");
        Kullanici kullanici;

        //sistem acilir
        while(1==1) {

            //menu
            System.out.println("\n   MENU");
            System.out.println("1. Alici girisi");
            System.out.println("2. Satici girisi");
            System.out.println("3. Alici kaydi ");
            System.out.println("4. Satici kaydi ");
            System.out.println("5. Cikis");
            System.out.print("Bir secim yapin: ");
            int secim = scanner.nextInt();

            //yapilan secime gore ilgili islemler yapilir

            //satici girisi
            if(secim == 2){
                System.out.print("Kullanici adi: ");
                String kullaniciAdi = scanner.next();
                kullanici = saticiBul(saticilar,kullaniciAdi);
                System.out.print("Parola: ");
                String password = scanner.next();

                //eger boyle bir kullanici yoksa veya parola yanlis ise giris yapilmaz
                if(kullanici == null || !kullanici.getPassword().equals(password)){
                    System.out.println("Kullanici adi veya password yanlis!");
                    continue;
                }
                System.out.println("\nHosgeldin " + kullanici.getAd() + " " + kullanici.getSoyad());
                //giris yapildi ise saticiya menusu gosterilir
                saticiMenu((Satici)kullanici);
            
            //alici girisi
            }else if(secim == 1){
                System.out.print("Kullanici adi: ");
                String kullaniciAdi = scanner.next();
                kullanici = aliciBul(alicilar,kullaniciAdi);
                System.out.print("Parola: ");
                String password = scanner.next();   

                //eger boyle bir kullanici yoksa veya parola yanlis ise giris yapilmaz
                if(kullanici == null || !kullanici.getPassword().equals(password)){
                    System.out.println("Kullanici adi veya password yanlis!");
                    continue;
                }
                System.out.println("\nHosgeldin " + kullanici.getAd() + " " + kullanici.getSoyad());
                //giris yapildi ise aliciya menusu gosterilir
                aliciMenu(saticilar,(Alici)kullanici);

            //alici kaydi
            }else if(secim == 3){
                //kayit icin gerekli bilgiler kullanicidan istenir
                System.out.println("Kayit olmak icin gerekli bilgileri giriniz.");
                System.out.print("Ad: ");
                String ad = scanner.next();
                System.out.print("Soyad: ");
                String soyad = scanner.next();
                System.out.print("Kullanici adi: ");
                String kullaniciAdi = scanner.next();

                //eger kullanici adi kullanildi ise kayda izin verilmez
                if(aliciBul(alicilar,kullaniciAdi) != null || saticiBul(saticilar,kullaniciAdi) != null){
                    System.out.println("Bu kullanici adi kullanilmis!");
                    continue;
                }
                System.out.print("Sifre: ");
                String password = scanner.next();
                System.out.print("TC: ");
                String TC = scanner.next();
                System.out.print("Tel: ");
                String tel = scanner.next();
                System.out.print("Email: ");
                String email = scanner.next();
                System.out.print("Adres: ");
                String adres = scanner.nextLine();
                System.out.print("Hesap miktari (TL): ");
                double cuzdan = scanner.nextDouble();

                //bilgiler alindiktan sonra alici listesine yeni alici eklenir
                //artik alici kullanici ismiyle giris yapabilir
                alicilar.add(new Alici(ad,soyad,kullaniciAdi,password,TC,tel,email,adres,cuzdan));
            
            //satici kaydi
            }else if(secim == 4){
                //kayit icin gerekli bilgiler kullanicidan istenir
                System.out.println("Kayit olmak icin gerekli bilgileri giriniz.");
                System.out.print("Ad: ");
                String ad = scanner.next();
                System.out.print("Soyad: ");
                String soyad = scanner.next();
                System.out.print("Kullanici adi: ");
                String kullaniciAdi = scanner.next();

                if(aliciBul(alicilar,kullaniciAdi) != null || saticiBul(saticilar,kullaniciAdi) != null){
                    System.out.println("Bu kullanici adi kullanilmis!");
                    continue;
                }
                System.out.print("Sifre: ");
                String password = scanner.next();
                System.out.print("TC: ");
                String TC = scanner.next();
                System.out.print("Tel: ");
                String tel = scanner.next();
                System.out.print("Email: ");
                String email = scanner.next();
                System.out.print("Adres: ");
                String adres = scanner.nextLine();

                //bilgiler alindiktan sonra satici listesine yeni satici eklenir
                //artik satici kullanici ismiyle giris yapabilir
                saticilar.add(new Satici(ad,soyad,kullaniciAdi,password,TC,tel,email,adres));
            }
            else if(secim == 5) break;
            else System.out.println("Yanlis secim!");
        }
        scanner.close();
        System.out.println("Sistemden cikis yapiliyor...");
    }

    public static void aliciMenu(ArrayList<Satici> saticilar,Alici alici){
        
        Scanner scanner = new Scanner(System.in);
        
        while(1==1){
            System.out.println("\nHesaptaki para miktari: " + alici.getCuzdan());
            System.out.println("   Alici Menu");
            System.out.println("1. Urun Listele");
            System.out.println("2. Satin Al");
            System.out.println("3. Siparis Gecmisi");
            System.out.println("4. Cikis");
            System.out.print("Secimizi yapin: ");
            int secim = scanner.nextInt();

            if(secim==1){
                for (Satici satici : saticilar) {
                    System.out.println(satici);
                    satici.urunListele();
                }
            }
            else if(secim==2){
                System.out.print("Alisveris yapmak istediginiz saticinin kullanici adini girin: ");
                String kullaniciAdi = scanner.next();

                boolean bulundu = false;
                for (Satici satici : saticilar) {
                    if (satici.getKullaniciAdi().equals(kullaniciAdi)) {
                        System.out.print("Satin alacaginiz urunun id'sini girin: ");
                        int id = scanner.nextInt();
                        System.out.println("Urun miktari: ");
                        double miktar = scanner.nextDouble();
                        alici.satinAl(satici,id,miktar);
                        bulundu = true;
                    }
                }

                if(!bulundu)
                    System.out.println("Boyle bir satici bulunmamaktadir!");
            }
            else if(secim==3) alici.siparisListele();
            else if(secim==4) break;
            else System.out.println("Yanlis secim!");
        }
    }

    public static void saticiMenu(Satici satici){

        Scanner scanner = new Scanner(System.in);
        
        while(1==1){
            System.out.println("\nHesaptaki para miktari: " + satici.getCuzdan());
            System.out.println("   Satici Menu");
            System.out.println("1. Urun Ekle");
            System.out.println("2. Urun Listele");
            System.out.println("3. Cikis");
            System.out.print("Secimizi yapin: ");
            int secim = scanner.nextInt();

            if(secim==1){
                System.out.print("Urun ismi (bosluk kullanmayiniz): ");
                String isim = scanner.next();
                System.out.print("Urun fiyati: ");
                double fiyat = scanner.nextDouble();
                System.out.print("Adet/miktar(kg): ");
                double miktar = scanner.nextDouble();
                satici.urunEkle(isim,fiyat,miktar);
            }
            else if(secim==2) satici.urunListele();
            else if(secim==3) break;
            else System.out.println("Yanlis secim!");
        }
    }

    public static Satici saticiBul(ArrayList<Satici> saticilar,String kullaniciAdi){
        for (Satici satici : saticilar) {
            if (satici.getKullaniciAdi().equals(kullaniciAdi))
                return satici;
        }
        return null;
    }

    public static Alici aliciBul(ArrayList<Alici> alicilar,String kullaniciAdi){
        for (Alici alici : alicilar) {
            if (alici.getKullaniciAdi().equals(kullaniciAdi))
                return alici;
        }
        return null;
    }
}
