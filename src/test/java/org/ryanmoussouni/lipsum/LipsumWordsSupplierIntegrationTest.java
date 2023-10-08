package org.ryanmoussouni.lipsum;

import org.junit.jupiter.api.*;
import org.ryanmoussouni.lipsum.ErrorHandling.TokenizationException;

@Tag("Integration")
class LipsumWordsSupplierIntegrationTest {

    private LipsumWordsSupplier tokenizer;

    @Test
    void creation_doesNotThrow() {
        try {
            tokenizer = new LipsumWordsSupplier();
        } catch (TokenizationException te) {
            Assertions.fail("Could not instanciate the tokenizer");
        }
    }
}