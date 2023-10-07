package org.ryanmoussouni.lipsum;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class LipsumWordsSupplier implements Tokenizer, VocabularySource {

    public static final String PATH_TO_CHAPTER_FROM_CICERO_BOOK = "deFinibusBonorumetMalorumS1.10.32.txt";
    private final InputStream lipsumFile;

    public LipsumWordsSupplier() throws TokenizationException {
        try {
            ClassPathResource cpr = new ClassPathResource(PATH_TO_CHAPTER_FROM_CICERO_BOOK);
            lipsumFile = cpr.getInputStream();
        } catch (IOException fne) {
            fne.printStackTrace();
            var message = "Could not set up the tokenizer: could not load the data source.";
            throw new TokenizationException(message, fne);
        }
    }

    public LipsumWordsSupplier(InputStream lipsumFile) {
        this.lipsumFile = lipsumFile;
    }

    @Override
    public List<String> tokenize() throws TokenizationException {
        try {
            String rawText = new String(lipsumFile.readAllBytes(), StandardCharsets.US_ASCII);
            var rawTokens = rawText.split(" ");
            return Arrays.stream(rawTokens)
                    .map(tkn -> tkn.replaceAll("\\p{Punct}", ""))
                    .map(tkn -> tkn.toLowerCase(Locale.ROOT))
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            var message = "Could not tokenize: error while reading data from the data source.";
            throw new TokenizationException(message, ioe);
        }
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

    @Override
    public Set<String> getVocabulary() throws VocabularyCreationException {
        try {
            var tokens = tokenize();
            return new HashSet<>(tokens);
        } catch (TokenizationException e) {
            e.printStackTrace();
            throw new VocabularyCreationException(e);
        }
    }
}
