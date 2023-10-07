package org.ryanmoussouni.lipsum;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LipsumTokenizer implements Tokenizer {

    public static final String PATH_TO_CHAPTER_FROM_CICERO_BOOK = "resources/static/deFinibusBonorumetMalorumS1.10.32.txt";
    private final FileReader lipsumFile;

    public LipsumTokenizer() throws TokenizationException {
        try {
            lipsumFile = new FileReader(PATH_TO_CHAPTER_FROM_CICERO_BOOK);
        } catch (FileNotFoundException fne) {
            var message = "Could not set up the tokenizer: could not load the data source.";
            throw new TokenizationException(message, fne);
        }
    }

    @Override
    public List<String> tokenize() throws TokenizationException {
       return null;
    }

    public void tearDown() throws TokenizationException {
        try {
            this.lipsumFile.close();
        } catch (IOException ioe) {
            var message = "Could not free the resources used by the tokenizer.";
            throw new TokenizationException(message, ioe);
        }
    }
}
