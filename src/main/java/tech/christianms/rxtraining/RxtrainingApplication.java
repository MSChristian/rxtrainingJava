package tech.christianms.rxtraining;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import tech.christianms.rxtraining.domain.model.LookDocument;
import tech.christianms.rxtraining.domain.repository.LookRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class RxtrainingApplication {

    @Autowired
    private LookRepository lookRepository;

    public static void main(String[] args) {
        SpringApplication.run(RxtrainingApplication.class, args);
    }

    @PostConstruct
    @Transactional
    public void init() {
        var look = LookDocument.builder()
                .id(1)
                .name("look1")
                .datePublished(7945L)
                .build();
        lookRepository.save(look).subscribe(data -> {
            log.info("Look guardado:  {}", data.toString());
        });
    }

}
