
import java.util.ArrayList;



public abstract class oyuncu {
    
    private int oyuncuID;
    private String oyuncuAdi;
    private int Skor;
    private ArrayList<Pokemon> kartListesi;
    
    public int getOyuncuID() {
        return oyuncuID;
    }

    public ArrayList<Pokemon> getCards() {
        return kartListesi;
    }

    public void setCards(ArrayList<Pokemon> cards) {
        this.kartListesi = cards;
    }
    public void setCards(Pokemon cards) {
        this.kartListesi.add(cards);
    }
    public void setCards(Pokemon card , int index) {
        this.kartListesi.set(index, card);
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }
 
    
    public oyuncu(int oyuncuID , String oyuncuAdi , int Skor){
        kartListesi = new ArrayList<Pokemon>();
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.Skor = Skor;
        
    }
    public oyuncu(){
        
    }
    
    public abstract Pokemon kartSec();
    
    public void SkorGoster(){
        
    }   
    
    
}
