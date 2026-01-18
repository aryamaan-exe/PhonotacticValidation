import java.util.*;

public enum Place {
    BILABIAL, LABIODENTAL, DENTAL, ALVEOLAR, POSTALVEOLAR, RETROFLEX, PALATAL, UVULAR, PHARYNGEAL, GLOTTAL
}

public enum Manner {
    PLOSIVE, FRICATIVE, NASAL, LIQUID, GLIDE, VOWEL
}

public class Phoneme {
	private final String symbol;
	private final boolean isVowel;
	private static final List<String> knownVowels = new ArrayList<>(List.of("a", "e", "i", "o", "u"));
    private final Integer sonority;
    private Map<Manner, int> sonorityMap;

    private static void createSonorityMap() {
        sonorityMap.put(Manner.PLOSIVE, 1);
        sonorityMap.put(Manner.FRICATIVE, 2);
        sonorityMap.put(Manner.NASAL, 3);
        sonorityMap.put(Manner.LIQUID, 4);
        sonorityMap.put(Manner.GLIDE, 5);
        sonorityMap.put(Manner.VOWEL, 6);
    }

	public Phoneme(String _symbol, Boolean _isVowel, Integer _sonority) {
        createSonorityMap();

		symbol = _symbol;
        if (_isVowel == null) {
            isVowel = checkVowel(_symbol);
        } else {
            isVowel = _isVowel;
        }

        if (_sonority == null) {
            sonority = checkSonority(_symbol);
        } else {
            sonority = _sonority;
        }
	}

	public static boolean checkVowel(String symbol) {
        return knownVowels.contains(symbol);
    }

    public static Manner checkManner(String symbol) {
        if (checkVowel) return Manner.VOWEL;

        return null;
        // TODO: fill this out
    }

    public static int checkSonority(String symbol) {
        return sonorityMap.get(checkManner(symbol));
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isVowel() {
        return isVowel;
    }

    public int getSonority() {
        return sonority;
    }
}

public class Syllable {
	private final List<Phoneme> onset;
	private final Phoneme nucleus;
	private final List<Phoneme> coda;

    public Syllable(List<Phoneme> _onset, Phoneme _nucleus, List<Phoneme> _coda) {
        onset = _onset;
        nucleus = _nucleus;
        coda = _coda;
    }

    public static boolean validOnset() {
        if (onset.size() > 3) return false;

        if (!(onset.get(0).getSymbol().equals("s"))) {
            for (int i = 0; i < onset.size() - 1; i++) {
                if (onset.get(i).getSonority() >= onset.get(i + 1).getSonority()) {
                    return false;
                }

                if (onset.get(i).getSymbol().equals(onset.get(i + 1).getSymbol())) {
                    return false;
                }
            }
        }

        for (Phoneme p : onset) {
            if (p.getSymbol().equals("ŋ")) return false;
        }

        return true;
    }

    public static boolean validNucleus() {
        if (nucleus.size() == 0) return false;
        
        int i = 0;
        for (Phoneme p : nucleus) {
            if (p.isVowel()) i++;
        }

        return i == 1;
    }

    public static boolean validCoda() {
        for (int i = 0; i < coda.size() - 1; i++) {
            if (coda.get(i).getSonority() <= coda.get(i + 1).getSonority()) {
                return false;
            }

            if (coda.get(i).getSymbol().equals(coda.get(i + 1).getSymbol())) {
                return false;
            }
        }

        return true;
    }

    public static boolean validSyllable() {
        return validOnset() && validNucleus() && validCoda(); 
    }
}

public class main {
	public static void main(String[] args) {
        
	}
}
