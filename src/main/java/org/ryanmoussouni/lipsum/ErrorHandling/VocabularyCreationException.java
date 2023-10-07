package org.ryanmoussouni.lipsum.ErrorHandling;

import org.ryanmoussouni.lipsum.ErrorHandling.TokenizationException;

public class VocabularyCreationException extends Throwable {
    public VocabularyCreationException(TokenizationException e) {
    }
}
