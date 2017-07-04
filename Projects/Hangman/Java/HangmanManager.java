
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HangmanManager {

    private Set<String> words;
    private Set<Character> guessed;
    private String pattern;
    private int len, guesses;

    //Contructor: list of words, length of the word being guessed, the total number of guesses allowed
    HangmanManager(List<String> dict, int length, int max) {
        if (length < 1 || max < 0) {
            throw new IllegalArgumentException();
        }

        guessed = new TreeSet<>();
        words = new TreeSet<>();

        //Sets pattern to a blank template
        pattern = "";
        for (int i = 0; i < length; i++) {
            pattern += "-";
        }

        //Adds all words from the dict that meet length requirement
        dict.stream().forEach((w) -> {
            if (w.length() == length) {
                words.add(w);
            }
        });

        //Assigns params to instance vars 
        len = length;
        guesses = max;
        
    }

    //Creates a pattern that implements the old pattern and the new char c
    //for String w
    private String getPattern(String w, char c) {
        String p = "";
        for (int i = 0; i < len; i++) {
            if (w.charAt(i) == c) {
                p += c;
            } else {
                p += pattern.charAt(i);
            }
        }
        return p;
    }

    //Counts the number of char c in String w
    private int countOccurences(String w, char c) {
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (w.charAt(i) == c) {
                cnt++;
            }
        }
        return cnt;
    }

    //Records a player guess of char ch
    int record(char ch) {
        if (guesses == 0 || words.isEmpty()) {
            throw new IllegalStateException();
        } else if (!(ch >= 97 && ch <= 122 && !guessed.contains(ch))) {
            throw new IllegalArgumentException();
        }

        //Creates a map with patterns paired with a Set of the words that match it
        Map<String, Set<String>> map = new TreeMap<>();
        words.stream().forEach((w) -> {
            String pat = getPattern(w, ch);
            if (map.get(pat) == null) {
                Set<String> k = new TreeSet<>();
                k.add(w);
                map.put(pat, k);
            } else {
                map.get(pat).add(w);
            }
        });

        //Finds the best possible pattern with the most words that fit it
        Set<String> bestWords = null;
        String bestPattern = null;
        for (String pattrn : map.keySet()) {
            if (bestWords == null || bestWords.size() < map.get(pattrn).size()) {
                bestWords = map.get(pattrn);
                bestPattern = pattrn;
            }
        }

        //Update words and pattern to the new ones after the guess
        words = bestWords;
        pattern = bestPattern;

        //Subtract from the guesses if the new pattern doesnt include letter
        //and add the guess to the Set of guessed letters
        int cnt = countOccurences(pattern, ch);
        if (cnt == 0) {
            guesses--;
        }
        guessed.add(ch);

        //Return number of char c in new pattern
        return cnt;
    }

    //Returns Current Pattern
    String pattern() {
        return pattern;
    }

    //Returns Guesses Remaining
    int guessesLeft() {
        return guesses;
    }

    //Methods Return a Copy of Mutable Objects
    //Returns a Set of prev guessed chars
    Set<Character> guesses() {
        return new TreeSet<>(guessed);
    }

    //Returns the current Set of words that match the pattern
    Set<String> words() {
        return new TreeSet<>(words);
    }

}
