package org.ryanmoussouni.lipsum;

import org.ryanmoussouni.lipsum.ErrorHandling.TokenizationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Tokenizer {
    List<String> tokenize() throws TokenizationException;
}
