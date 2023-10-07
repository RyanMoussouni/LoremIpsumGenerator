package org.ryanmoussouni.lipsum;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping(path = "lipsum", method = RequestMethod.GET)
    public ResponseEntity<String> handleTextGenerationRequest() {
        var body = "test";
        var status = HttpStatus.OK;
        return new ResponseEntity<>(body, status);
    }
}
