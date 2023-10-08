package org.ryanmoussouni.lipsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ryanmoussouni.lipsum.ErrorHandling.TokenizationException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LipsumWordsSupplierTest {

    @Test
    void tokenize_singleSentence_returnsAllTokensInOrder() throws IOException, TokenizationException {
        var sentence = "Sed ut perspiciatis, unde omnis iste natus error.";
        var tokenizer = new LipsumWordsSupplier(sentence);
        var expectedTokens = List.of("sed", "ut", "perspiciatis", "unde", "omnis", "iste", "natus", "error");

        var actualTokens = tokenizer.tokenize();

        Assertions.assertArrayEquals(expectedTokens.toArray(), actualTokens.toArray());
    }
}