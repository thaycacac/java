/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextCounter;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author hailiang194
 */
public class TextCounter {

    private final String content;
    private HashMap<String, Integer> words;
    private HashMap<Character, Integer> characters;

    public TextCounter(String content) {
        this.content = content;
        this.words = new HashMap<>();
        this.characters = new HashMap<>();
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }

    public HashMap<Character, Integer> getCharacters() {
        return characters;
    }

    public void count() {
        this.words.clear();
        this.characters.clear();
        StringTokenizer tokenizer = new StringTokenizer(content, " \t()[]{}\"\'.?!;");

        //count word
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();

            if (!this.words.containsKey(word)) {
                this.words.put(word, 1);
            } else {
                this.words.replace(word, this.words.get(word) + 1);
            }

            //count word
            for (int i = 0; i < word.length(); ++i) {
                char chr = word.charAt(i);

                if (!Character.isAlphabetic(chr)) {
                    continue;
                }

                if (!this.characters.containsKey(chr)) {
                    this.characters.put(chr, 1);
                } else {
                    this.characters.replace(chr, this.characters.get(chr) + 1);
                }
            }

        }
    }

}
