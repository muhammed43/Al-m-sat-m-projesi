import java.util.ArrayList;

public class Satici extends Kullanici{
    
    //saticilarin urunleri vardir
    private ArrayList<Urun> urunler;
    //urun id'leri 1 ile baslar
    int urunID = 1;

    //yapilandirici
    public Satici(String ad,String soyad,String kullaniciAdi,String password,String TC,String tel,String email,
    String adres) {
        super(ad, soyad, kullaniciAdi, password, TC, tel, email, adres, 0.0);
        urunler = new ArrayList<>();
    }

    //verilen isim,fiyat ve stok bilgileri ile urun olusturulup listeye eklenir
    public void urunEkle(String isim,double fiyat,double stok){
        urunler.add(new Urun(urunID,isim,fiyat,stok));
        this.urunID++;
        System.out.println("Urun basariyla sisteme eklendi!");
    }

    //verilen id'ye sahip urun bulunur
    public Urun urunBul(int id){
        for (Urun urun : urunler) {
            if(urun.getId() == id)
                return urun;
        }
        return null;
    }

    //verilen id'ye sahip urun verilen miktarda satilir,elde edilen gelir saticinin cuzdanina eklenir
    //ve stoktan miktar dusulur.
    //eger stokta yeterli miktarda urun yoksa satisi yapilmaz!
    public boolean urunSat(int id,double miktar){
        Urun urun = urunBul(id);

        if(urun == null){
            System.out.println("Urun bulunamadi!");
            return false;
        }
        if(urun.getStok() < miktar || urun.getStok() == 0){
            System.out.println("Istenilen urun stokta yeterli miktarda bulunmamaktadir!");
            return false;
        }

        double ucret = miktar * urun.getFiyat();
        this.setCuzdan(this.getCuzdan()+ucret);
        urun.setStok(urun.getStok()-miktar);
        System.out.println("Urun basariyla satildi");
        return true;
    }

    //saticinin urunleri listelenir, eger urunu yoksa kullanici bilgilendirilir
    public void urunListele(){
        if(urunler.isEmpty()){
            System.out.println("Kayitli urununuz bulunmamaktadir!");
            return;
        }
        System.out.println("Urunler");
        for (Urun urun : urunler)
            System.out.println(urun);
    }

    @Override
    public String toString() {
        return "\nSatici :" + this.getKullaniciAdi();
    }
}
