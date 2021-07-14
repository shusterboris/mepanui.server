package application.controllers;

import application.entities.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OffersController {
    @GetMapping(value = "offers/answers/get/byId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Answer>> getAnswerByOffer(Long offerId){
        List<Answer> list = new ArrayList<>();
        Answer s = new Answer();
        s.setNotes("Сделаю быстро");
        list.add(s);
        s = new Answer();
        s.setNotes("Сделаю красиво");
        list.add(s);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
