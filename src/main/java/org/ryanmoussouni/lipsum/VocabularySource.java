package org.ryanmoussouni.lipsum;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface VocabularySource {
    Set<String> getVocabulary() throws VocabularyCreationException;
}
