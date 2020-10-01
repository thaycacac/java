/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import TextNormalization.TextNormalizer;
import TextNormalization.normalizer.DotAtTheEndNormalizer;
import TextNormalization.normalizer.NoSpaceInQuoteNormalizer;
import TextNormalization.normalizer.OnlySpaceBetweenMarkNormalizer;
import TextNormalization.normalizer.OnlySpaceAfterMarkNormalizer;
import TextNormalization.normalizer.OnlySpaceBetweenWordsNormalizer;
import TextNormalization.normalizer.UppercaseFirstCharOfSentenceNormalizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class Main {

    /**
     * read file
     *
     * @param filename file name of read file
     * @return content of file
     */
    public static String readFile(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String content = new String();
        String line = null;

        while ((line = reader.readLine()) != null) {
            content += (line + '\n');
        }

        return content.substring(0, content.length() - 1); //remove \n at the end
    }

    /**
     * write to file
     * @param content written content
     * @param filename filename of written file
     */
    public static void writeFile(String content, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
    }

    public static void main(String[] args) {
        TextNormalizer normalizer = new TextNormalizer();
        
        normalizer.addNormalizer(new OnlySpaceBetweenWordsNormalizer());
        normalizer.addNormalizer(new OnlySpaceAfterMarkNormalizer(","));
        normalizer.addNormalizer(new OnlySpaceAfterMarkNormalizer(":"));
        normalizer.addNormalizer(new UppercaseFirstCharOfSentenceNormalizer());
        //This also include same function with OnlySpaceBetweenMarkNormalizer(".")
        normalizer.addNormalizer(new DotAtTheEndNormalizer());
        normalizer.addNormalizer(new OnlySpaceBetweenMarkNormalizer("\""));
        normalizer.addNormalizer(new NoSpaceInQuoteNormalizer());
        
        String content = null;
        
        System.out.print("READING input.txt...");
        try {
            content = readFile("input.txt");
        } catch (IOException ex) {
            System.out.println("FAIL");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("DONE");
        
        System.out.print("NORMALIZING CONTENT...");
        String normalized = normalizer.normalize(content);
        System.out.println("DONE");

        System.out.println("WRITING CONTENT TO output.txt");
        try {
            writeFile(normalized, "output.txt");
        } catch (IOException ex) {
            System.out.println("FAIL.");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("DONE");
    }
}
