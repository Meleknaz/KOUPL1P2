
public class Pokemon {
    
    private int PokemonID;
    private String PokemonAdi;
    private String PokemonTip;
    private int hasarPuani;
    private String PokemonIcon;
	private boolean kart_kullanildimi;
	
    public Pokemon(){
        
    }
    public Pokemon(int pokemonID , String PokemonAdi ,String PokemonTip , int puan , String pokemonIcon , boolean kart_kullanildimi){  
    	this.PokemonID = pokemonID;
        this.PokemonAdi = PokemonAdi;
        this.PokemonTip = PokemonTip;
        this.hasarPuani = puan;
        this.PokemonIcon = pokemonIcon;
        this.kart_kullanildimi = kart_kullanildimi;
    }
    

    public void setPokemonID(int PokemonID) {
        this.PokemonID = PokemonID;
    }
    
    public int getPokemonID() {
        return PokemonID;
    }
    

    public void setPokemonAdi(String PokemonAdi) {
        this.PokemonAdi = PokemonAdi;
    }
    public String getPokemonAdi() {
        return PokemonAdi;
    }

    public void setPokemonTip(String PokemonTip) {
        this.PokemonTip = PokemonTip;
    }

    public String getPokemonTip() {
        return PokemonTip;
    }

    public void setHasarPuani(int hasarPuani) {
        this.hasarPuani = hasarPuani;
    }

    public int getHasarPuani() {
        return hasarPuani;
    }
	public void setPokemonIcon(String pokemonIcon) {
		PokemonIcon = pokemonIcon;
	}
    
	public String getPokemonIcon() {
		return PokemonIcon;
	}

	public boolean getKart_kullanildimi() {
		return kart_kullanildimi;
	}
	public void setKart_kullanildimi(boolean kart_kullanildimi) {
		this.kart_kullanildimi = kart_kullanildimi;
	}
       
    public void hasarPuaniGoster(){  
        System.out.println("hasar puani: "+this.hasarPuani);
        
    }
    public void ozellikGoster(){
        System.out.println("adi: "+PokemonAdi+"\ntipi: "+this.PokemonTip);
    }
}
