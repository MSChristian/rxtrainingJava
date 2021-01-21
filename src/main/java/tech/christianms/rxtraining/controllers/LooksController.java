package tech.christianms.rxtraining.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.christianms.rxtraining.domain.model.LookDocument;
import tech.christianms.rxtraining.dto.LookDto;
import tech.christianms.rxtraining.services.LooksService;

@RestController
@RequestMapping("looks")
@RequiredArgsConstructor
public class LooksController {

    private final LooksService looksService;

    @GetMapping
    @ResponseBody
    public Flux<LookDocument> getAllLooks() {
        return looksService.getAllLooks();
    }

    @DeleteMapping("/{lookId}")
    public Mono<Void> deleteLook(@PathVariable Integer lookId) {
        return looksService.deleteLook(lookId);
    }


    @PostMapping
    public Mono<LookDocument> saveLook(@RequestBody LookDto look) {
        return looksService.saveLook(look);
    }
}
