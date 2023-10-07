package org.ryanmoussouni.lipsum;

import java.util.List;

public interface Tokenizer {
    List<String> tokenize() throws TokenizationException;
}
