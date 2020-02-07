import java.util.Random;

public class bilgisayar extends oyuncu {
	private Random randomGenerator;

    public bilgisayar(){
        
    }
    
    public bilgisayar(int oyuncuID , String oyuncuAdi , int Skor ){
         super(oyuncuID,oyuncuAdi,Skor);
         randomGenerator = new Random();
    }
    
    
    @Override
    public Pokemon kartSec() {
        int index = randomGenerator.nextInt(this.getCards().size());
        Pokemon poke = this.getCards().get(index);
        return poke;
    }
}
