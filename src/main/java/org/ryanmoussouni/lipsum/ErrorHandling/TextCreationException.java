package org.ryanmoussouni.lipsum.ErrorHandling;

public class TextCreationException extends Throwable {
    public TextCreationException(String message, VocabularyCreationException e) {
        super(message, e);
    }
}
