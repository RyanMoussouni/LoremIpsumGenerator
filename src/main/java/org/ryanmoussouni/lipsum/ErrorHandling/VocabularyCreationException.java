package org.ryanmoussouni.lipsum.ErrorHandling;

public class VocabularyCreationException extends Throwable {
    public VocabularyCreationException(TokenizationException e) {
    }
}
