package org.ryanmoussouni.lipsum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LipsumTokenizerTest {

    private LipsumTokenizer tokenizer;

    @BeforeEach
    void setUp() {
        try {
            tokenizer = new LipsumTokenizer();
        } catch (TokenizationException te) {
            Assertions.fail("Could not instanciate the tokenizer");
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