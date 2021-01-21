package tech.christianms.rxtraining.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.christianms.rxtraining.domain.model.LookDocument;
import tech.christianms.rxtraining.dto.LookDto;


public interface LooksService {


    Flux<LookDocument> getAllLooks();

    Mono<LookDocument> saveLook(LookDto look);

    Mono<Void> deleteLook(Integer lookId);
}
