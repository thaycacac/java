/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author hailiang194
 */
public class FileFinder {

    private final File file;

    public FileFinder(File file) {
        this.file = file;
    }

    /**
     * read the content of file
     *
     * @return content of file
     */
    private String read() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.file));
        } catch (FileNotFoundException ex) {
            return new String();
        }

        String content = new String();
        String line = null;

        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException ex) {
                return content;
            }

            if (line == null) //EOF
            {
                break;
            }

            content += (line + '\n');
        }

        return content.substring(0, content.length() - 1); //remove '\n'
    }

    /**
     * count how many times word appears in file
     *
     * @param word appeared word
     * @return times word appears
     */
    public int occurrence(String word) {
        int count = 0;

        String content = this.read();

        StringTokenizer tokenizer = new StringTokenizer(content, " \t()[]{}\"\'.?!;");

        while (tokenizer.hasMoreTokens()) {
            if (word.equalsIgnoreCase(tokenizer.nextToken().trim())) {
                count++;
            }
        }

        return count;
    }

    /**
     * check if word is in file
     * @param word checked word
     * @return true if word in file, otherwise false
     */
    public boolean contain(String word) {
        return this.occurrence(word) > 0;
    }
}
