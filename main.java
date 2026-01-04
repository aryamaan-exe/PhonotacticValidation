import java.util.*;

public class Phoneme {
	private final String symbol;
	private final boolean isVowel;
	private static final List<String> knownVowels = new ArrayList<>(List.of("a", "e", "i", "o", "u"));

	public Phoneme(String _symbol, boolean _isVowel) {
		symbol = _symbol;
		isVowel = _isVowel;
	}

	public Phoneme(String _symbol) {
		symbol = _symbol;
		isVowel = checkVowel(_symbol);
	}

	public static boolean checkVowel(String symbol) {
        // TODO: implement
        return true;
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
}

public class main {
	public static void main(String[] args) {

	}
}
