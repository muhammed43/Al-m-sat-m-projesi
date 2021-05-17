import java.util.Date;

public class Siparis {
    
    //her siparisin bir saticisi ve urunu vardir
    private Satici satici;
    private Urun urun;

    private double miktar;
    //islem zamani
    private Date islemZamani;

    //yapilandirici
    public Siparis(Satici satici,Urun urun,double miktar) {
        this.satici = satici;
        this.urun = urun;
        this.miktar = miktar;
        this.islemZamani = new Date();
    }

    //getter'lar
    public double getUcret() {
        return this.urun.getFiyat() * miktar;
    }
    public Satici getSatici() {
        return this.satici;
    }
    public Urun getUrun() {
        return this.urun;
    }
    public double getMiktar() {
        return this.miktar;
    }
    public Date getIslemZamani() {
        return this.islemZamani;
    }

    @Override
    public String toString() {
        return "------------\nSatici: " + this.satici.getKullaniciAdi() + "\nUrun Bilgisi\n" + urun + " ucret: " + getUcret() + " TL\n" +
        "Islem zamani " + this.getIslemZamani() + "\n";
    }
}
