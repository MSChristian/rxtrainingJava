package tech.christianms.rxtraining.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.christianms.rxtraining.domain.model.LookDocument;
import tech.christianms.rxtraining.domain.repository.LookRepository;
import tech.christianms.rxtraining.dto.LookDto;
import tech.christianms.rxtraining.services.LooksService;

@Service
@RequiredArgsConstructor
public class LooksServiceImpl implements LooksService {

    private final LookRepository lookRepository;

    @Override
    public Flux<LookDocument> getAllLooks() {
        return  lookRepository.findAll();
    }

    @Override
    @Transactional
    public Mono<LookDocument> saveLook(LookDto look) {
        var lookDoc = LookDocument.builder()
                .id(look.getId())
                .name(look.getName())
                .datePublished(look.getDatePublished())
                .build();
        return lookRepository.save(lookDoc);
    }

    @Override
    public Mono<Void> deleteLook(Integer lookId) {
        return lookRepository.deleteById(lookId);
    }
}
