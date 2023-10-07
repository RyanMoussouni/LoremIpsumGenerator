package org.ryanmoussouni.lipsum;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
       return null;
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
