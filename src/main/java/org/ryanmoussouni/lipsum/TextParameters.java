package org.ryanmoussouni.lipsum;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class TextParameters {
    private final Integer sentenceSize;
    private final Set<Character> punctuationCharacters;
    private final Integer sentenceCount;
    private final Float punctuationToVocabWordsProportion;
    private final Float commaToSemiColonProportion;
}
