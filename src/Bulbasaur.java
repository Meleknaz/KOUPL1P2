/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MONSTER
 */
public class Bulbasaur extends Pokemon{
    private final static int POKEMON_ID = 3;
    private final static String POKEMON_ADI="Bulbasaur";
    private final static String POKEMON_TIPI = "Çim";
    private final static int HASAR_PUANI = 50;
    private final static String POKEMON_ICON_LOCATÝON =  "images/bulbasaur.jpg";

    public Bulbasaur() { 
    	super(POKEMON_ID , POKEMON_ADI , POKEMON_TIPI , HASAR_PUANI , POKEMON_ICON_LOCATÝON , false);
    }
}
