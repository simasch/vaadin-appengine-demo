package io.seventytwo.demo.gae;

import io.seventytwo.demo.gae.model.people.Person;
import io.seventytwo.demo.gae.model.people.PersonRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AppRunner implements ApplicationRunner {

    private final PersonRepository repository;

    public AppRunner(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (repository.count() == 0) {
            var john = new Person();
            john.setName("John Doe");
            repository.save(john);

            var jane = new Person();
            jane.setName("Jane Doe");
            repository.save(jane);
        }
    }
}
