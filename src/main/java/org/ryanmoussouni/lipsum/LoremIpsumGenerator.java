package org.ryanmoussouni.lipsum;

import lombok.AllArgsConstructor;
import org.ryanmoussouni.lipsum.ErrorHandling.VocabularyCreationException;

import java.util.Random;
import java.util.Set;

@AllArgsConstructor
public class LoremIpsumGenerator implements TextFactory {
    public static final String SEMICOLON = ";";
    public static final String COMMA = ",";
    public static final String DOT = ".";
    public static final String SPACE = " ";
    private VocabularySource loremIpsumWordsSupplier;

    @Override
    public String create(TextParameters params) throws TextCreationException {
        try {
            var vocabulary = loremIpsumWordsSupplier.getVocabulary();
            var stringBuilder = new StringBuilder();
            for (int i = 0; i < params.getSentenceCount(); i++) {
                var generatedSentence = createSentence(params, vocabulary);
                stringBuilder.append(generatedSentence);
            }
            return String.join(DOT, stringBuilder);
        } catch (VocabularyCreationException e) {
            e.printStackTrace();
            var message = "Could not create the text: the vocabulary could not be created.";
            throw new TextCreationException(message, e);
        }
    }

    private String createSentence(TextParameters params, Set<String> vocabulary) {
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < params.getSentenceSize(); i++) {
            String nextElement = shouldBePunctuationCharacter(params) ? pickCommaOrSemiColon(params)
                    : pickRandomWordFromVocabulary(vocabulary);
            stringBuilder.append(nextElement);
        }
        return String.join(SPACE, stringBuilder);
    }

    private boolean shouldBePunctuationCharacter(TextParameters params) {
        var rd = new Random();
        return rd.nextFloat() < params.getPunctuationToVocabWordsProportion();
    }

    private String pickCommaOrSemiColon(TextParameters params) {
        var rd = new Random();
        return rd.nextFloat() < params.getCommaToSemiColonProportion() ? COMMA
                : SEMICOLON;
    }

    private String pickRandomWordFromVocabulary(Set<String> vocabulary) {
        var rd = new Random();
        var vocabSize = vocabulary.size();
        var randomIndex = rd.nextInt(vocabSize);

        int i = 0;
        for (String word : vocabulary) {
            if (i == randomIndex) {
                return word;
            }
        }
        return vocabulary.stream()
                .findAny()
                .orElse("");
    }
}
