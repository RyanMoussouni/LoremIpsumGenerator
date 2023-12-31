package org.ryanmoussouni.lipsum;

import org.ryanmoussouni.lipsum.ErrorHandling.TokenizationException;
import org.ryanmoussouni.lipsum.ErrorHandling.VocabularyCreationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class LipsumWordsSupplier implements Tokenizer, VocabularySource {

    public static final String PATH_TO_CHAPTER_FROM_CICERO_BOOK = "deFinibusBonorumetMalorumS1.10.32.txt";
    private final String rawText;

    public LipsumWordsSupplier() throws TokenizationException {
        try {
            ClassPathResource cpr = new ClassPathResource(PATH_TO_CHAPTER_FROM_CICERO_BOOK);
            var lipsumFile = cpr.getInputStream();
            rawText = new String(lipsumFile.readAllBytes(), StandardCharsets.US_ASCII);
        } catch (IOException fne) {
            fne.printStackTrace();
            var message = "Could not set up the tokenizer: could not load the data source.";
            throw new TokenizationException(message, fne);
        }
    }

    public LipsumWordsSupplier(String rawTextSource) {
        this.rawText = rawTextSource;
    }

    @Override
    public List<String> tokenize() throws TokenizationException {
        var rawTokens = rawText.split(" ");
        return Arrays.stream(rawTokens)
                .map(tkn -> tkn.replaceAll("\\p{Punct}", ""))
                .map(tkn -> tkn.toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
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
