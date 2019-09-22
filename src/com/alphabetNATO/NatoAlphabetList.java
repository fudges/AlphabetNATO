package com.alphabetNATO;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NatoAlphabetList {
    private Map<String,String> natoalphabet = new HashMap<>();

    NatoAlphabetList() {
        natoalphabet.put("A","ALPHA");
        natoalphabet.put("B","BRAVO");
        natoalphabet.put("C","CHARLIE");
        natoalphabet.put("D","DELTA");
        natoalphabet.put("E","ECHO");
        natoalphabet.put("F","FOXTROT");
        natoalphabet.put("G","GOLF");
        natoalphabet.put("H","HOTEL");
        natoalphabet.put("I","INDIA");
        natoalphabet.put("J","JULIET");
        natoalphabet.put("K","KILO");
        natoalphabet.put("L","LIMA");
        natoalphabet.put("M","MIKE");
        natoalphabet.put("N","NOVEMBER");
        natoalphabet.put("O","OSCAR");
        natoalphabet.put("P","PAPA");
        natoalphabet.put("Q","QUEBEC");
        natoalphabet.put("R","ROMEO");
        natoalphabet.put("S","SIERRA");
        natoalphabet.put("T","TANGO");
        natoalphabet.put("U","UNIFORM");
        natoalphabet.put("V","VICTOR");
        natoalphabet.put("W","WHISKEY");
        natoalphabet.put("X","XRAY");
        natoalphabet.put("Y","YANKEE");
        natoalphabet.put("Z","ZULU");
    }

    Object getRandom(){
        Object[] crunchifyKeys = natoalphabet.keySet().toArray();
        Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
        return key;
    }

    Map<String, String> getNatoalphabet() {
        return natoalphabet;
    }

    public void remove(Object key){
        natoalphabet.remove(key);
    }
}
