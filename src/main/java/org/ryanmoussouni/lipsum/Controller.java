package org.ryanmoussouni.lipsum;

import lombok.AllArgsConstructor;
import org.ryanmoussouni.lipsum.ErrorHandling.TextCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Controller {
    private static final TextParameters generationParams = TextParameters.builder()
            .sentenceSize(10)
            .sentenceCount(5)
            .commaToSemiColonProportion(0.8F)
            .punctuationToVocabWordsProportion(0.1F)
            .build();
    private final TextFactory lipsumGenerator;

    @RequestMapping(path = "lipsum", method = RequestMethod.GET)
    public ResponseEntity<String> handleTextGenerationRequest() {
        try {
            var body = lipsumGenerator.create(generationParams);
            var status = HttpStatus.OK;
            return new ResponseEntity<>(body, status);
        } catch (TextCreationException e) {
            e.printStackTrace();
            var status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(status);
        }
    }
}
