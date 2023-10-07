package org.ryanmoussouni.lipsum;

import java.io.File;
import java.util.List;

public class LipsumTokenizer implements Tokenizer {

    public static final String CHAPTER_FROM_CICERO_BOOK = "resources/static/deFinibusBonorumetMalorumS1.10.32.txt";
    private final File lipsumFile;

    public LipsumTokenizer() {
        lipsumFile = new File(CHAPTER_FROM_CICERO_BOOK);
    }

    @Override
    public List<String> tokenize() throws TokenizationException {
       return null;
    }
}
