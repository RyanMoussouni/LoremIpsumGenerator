package org.ryanmoussouni.lipsum;

import lombok.Getter;

import java.util.Set;

@Getter
public class TextParameters {
    private Integer sentenceSize;
    private Set<Character> punctuationCharacters;
}
