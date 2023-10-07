package org.ryanmoussouni.lipsum.ErrorHandling;

import org.ryanmoussouni.lipsum.ErrorHandling.VocabularyCreationException;

public class TextCreationException extends Throwable {
    public TextCreationException(String message, VocabularyCreationException e) {
        super(message, e);
    }
}
