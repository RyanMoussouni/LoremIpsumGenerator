package org.ryanmoussouni.lipsum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ryanmoussouni.lipsum.ErrorHandling.TextCreationException;
import org.ryanmoussouni.lipsum.ErrorHandling.VocabularyCreationException;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoremIpsumGeneratorTest {

    @Test
    void create_any_returnsSomething() throws VocabularyCreationException {
        var vocabSourceStub = mock(VocabularySource.class);
        var vocabFixture = Set.of("this", "is", "my", "vocab");
        var textParamFixture = new TextParameters(3, Set.of(), 5, (float) 0.2, 9F);
        when(vocabSourceStub.getVocabulary())
                .thenReturn(vocabFixture);
        var generator = new LoremIpsumGenerator(vocabSourceStub);

        try {
            generator.create(textParamFixture);
        } catch (TextCreationException tce) {
            Assertions.fail("The function could not return");
        }
    }
}