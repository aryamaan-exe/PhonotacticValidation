import java.util.*;

public class Phoneme {
	private final String symbol;
	private final boolean isVowel;
	private static final List<String> knownVowels = new ArrayList<>(List.of("a", "e", "i", "o", "u"));
    private final int sonority;

	public Phoneme(String _symbol, boolean _isVowel, int _sonority) {
		symbol = _symbol;
		isVowel = _isVowel;
        sonority = _sonority;
	}

	public Phoneme(String _symbol, int _sonority) {
		symbol = _symbol;
		isVowel = checkVowel(_symbol);
        sonority = _sonority;
	}

	public static boolean checkVowel(String symbol) {
        return knownVowels.contains(symbol);
    }

    public static String getSymbol() {
        return symbol;
    }

    public static boolean isVowel() {
        return isVowel;
    }

    public static int getSonority() {
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
        for (int i = 0; i < onset.size() - 1; i++) {
            if (onset.get(i).getSonority() >= onset.get(i + 1).getSonority()) {
                return false;
            }
        }

        return true;
    }
}

public class main {
	public static void main(String[] args) {

	}
}
