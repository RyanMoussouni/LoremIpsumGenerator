package org.ryanmoussouni.lipsum;

import org.junit.jupiter.api.*;

@Tag("Integration")
class LipsumWordsSupplierIntegrationTest {

    private LipsumWordsSupplier tokenizer;

    @BeforeEach
    void setUp() {
        try {
            tokenizer = new LipsumWordsSupplier();
        } catch (TokenizationException te) {
            Assertions.fail("Could not instanciate the tokenizer");
        }
    }

    @Test
    void tokenize_doesNotThrow() {
        try {
            tokenizer.tokenize();
        } catch (TokenizationException te) {
            Assertions.fail("Tokenizer failure");
        }
    }

    @AfterEach
    void tearDown() {
        try {
            tokenizer.tearDown();
        } catch (TokenizationException e) {
            Assertions.fail("Could not teardown the tokenizer");
        }
    }
}