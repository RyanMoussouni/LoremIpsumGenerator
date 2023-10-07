package org.ryanmoussouni.lipsum;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Tokenizer {
    List<String> tokenize() throws TokenizationException;
}
