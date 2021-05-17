public class Kullanici {
    
    //tum kullanicilara ait bilgiler
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String password; 
    private String TC;
    private String tel;
    private String email;
    private String adres;

    //hesaplarindaki para miktari
    private double cuzdan;

    //yapilandirici
    public Kullanici(String ad,String soyad,String kullaniciAdi,String password,String TC,String tel,String email,
    String adres,double cuzdan){
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.password = password;
        this.TC = TC;
        this.tel = tel;
        this.email = email;
        this.adres = adres;
        this.cuzdan = cuzdan;
    }

    //getter ve setter'lar
    public String getAd() {
        return this.ad;
    }
    public String getSoyad() {
        return this.soyad;
    }
    public String getKullaniciAdi() {
        return this.kullaniciAdi;
    }
    public String getPassword() {
        return this.password;
    }
    public String getTC() {
        return this.TC;
    }
    public String getTel() {
        return this.tel;
    }
    public String getEmail() {
        return this.email;
    }
    public String getAdres() {
        return this.adres;
    }
    public double getCuzdan() {
        return this.cuzdan;
    }
    public void setCuzdan(double cuzdan) {
        this.cuzdan = cuzdan;
    }
}
