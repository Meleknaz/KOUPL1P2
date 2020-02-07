

public class insan extends oyuncu{

    public insan(){
        
    }
    
    public insan(int oyuncuID , String oyuncuAdi , int Skor ){
        super(oyuncuID,oyuncuAdi,Skor);
    }
    
    @Override
    public Pokemon kartSec() {
        
    	return this.getCards().get(0);
    }
    
}
