import java.util.ArrayList;

public class Alici extends Kullanici{

    //alicilarin siparisleri vardir
    private ArrayList<Siparis> siparisler;

    //yapilandirici
    public Alici(String ad,String soyad,String kullaniciAdi,String password,String TC,String tel,String email,
    String adres, double cuzdan) {
        super(ad, soyad, kullaniciAdi, password, TC, tel, email, adres, cuzdan);
        this.siparisler = new ArrayList<>();
    }

    //ilgili saticidan, verilen id'ye sahip urun verilen miktar kadar satilir
    //eger alicinin cuzdaninda yeterli miktarda nakit yoksa alim yapilmaz
    public boolean satinAl(Satici satici,int id,double miktar){

        if (satici.urunSat(id,miktar)) {
            Urun urun = satici.urunBul(id);
            double ucret = urun.getFiyat() * miktar;

            if (urun.getFiyat()*miktar > this.getCuzdan()) {
                System.out.println("Yeterli miktarda paraniz bulunmamaktadir!");
                return false;
            }
            this.setCuzdan(this.getCuzdan()-ucret);
            this.siparisler.add(new Siparis(satici,urun,miktar));
        }
        return false;
    }

    //aliciya ait siparisler listelenir,yoksa eger kullanici bilgilendirilir
    public void siparisListele(){
        if(siparisler.isEmpty()){
            System.out.println("Verilmis siparisiniz bulunmamaktadir");
            return;
        }
        System.out.println("\nSiparisler");
        for (Siparis siparis: siparisler) {
            System.out.println(siparis);
        }
    }
}