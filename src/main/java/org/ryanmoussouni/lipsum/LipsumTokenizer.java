package org.ryanmoussouni.lipsum;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class LipsumTokenizer implements Tokenizer {

    public static final String PATH_TO_CHAPTER_FROM_CICERO_BOOK = "deFinibusBonorumetMalorumS1.10.32.txt";
    private final InputStream lipsumFile;

    public LipsumTokenizer() throws TokenizationException {
        try {
            ClassPathResource cpr = new ClassPathResource(PATH_TO_CHAPTER_FROM_CICERO_BOOK);
            lipsumFile = cpr.getInputStream();
        } catch (IOException fne) {
            fne.printStackTrace();
            var message = "Could not set up the tokenizer: could not load the data source.";
            throw new TokenizationException(message, fne);
        }
    }

    public LipsumTokenizer(InputStream lipsumFile) {
        this.lipsumFile = lipsumFile;
    }

    @Override
    public List<String> tokenize() throws TokenizationException {
        try {
            String rawText = Arrays.toString(lipsumFile.readAllBytes());
            var rawTokens = rawText.split(" ");
            return Arrays.stream(rawTokens)
                    .filter(tkn -> !LipsumTokenizer.isPunctuation(tkn))
                    .map(tkn -> tkn.toLowerCase(Locale.ROOT))
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            var message = "Could not tokenize: error while reading data from the data source.";
            throw new TokenizationException(message, ioe);
        }
    }

    private static boolean isPunctuation(String s) {
        return s.matches("\\p{Punct}");
    }

    public void tearDown() throws TokenizationException {
        try {
            this.lipsumFile.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            var message = "Could not free the resources used by the tokenizer.";
            throw new TokenizationException(message, ioe);
        }
    }
}
