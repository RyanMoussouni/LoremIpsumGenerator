package org.ryanmoussouni.lipsum;

import org.ryanmoussouni.lipsum.ErrorHandling.TextCreationException;
import org.springframework.stereotype.Component;

@Component
public interface TextFactory {
    String create(TextParameters params) throws TextCreationException;
}
