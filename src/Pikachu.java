
import java.io.IOException;

public class Pikachu extends Pokemon {
	
    private final static  int POKEMON_ID = 0;
    private final static String POKEMON_ADI="Pikachu";
    private final static String POKEMON_TIPI = "Elektrik";
    private final static int HASAR_PUANI = 40;
    private final static String POKEMON_ICON_LOCATÝON =  "images/pikachu.png";
    
    public Pikachu() throws IOException { 
    	super(POKEMON_ID , POKEMON_ADI , POKEMON_TIPI , HASAR_PUANI , POKEMON_ICON_LOCATÝON , false);
    }

}


