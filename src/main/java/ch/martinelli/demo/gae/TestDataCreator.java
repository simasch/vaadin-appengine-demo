package ch.martinelli.demo.gae;

import ch.martinelli.demo.gae.model.people.Person;
import ch.martinelli.demo.gae.model.people.PersonRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDataCreator implements ApplicationRunner {

    private final PersonRepository repository;

    public TestDataCreator(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
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
