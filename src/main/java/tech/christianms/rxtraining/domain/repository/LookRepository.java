package tech.christianms.rxtraining.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import tech.christianms.rxtraining.domain.model.LookDocument;

public interface LookRepository extends ReactiveMongoRepository<LookDocument, Integer> {

}
