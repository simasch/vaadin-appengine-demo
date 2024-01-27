package ch.martinelli.demo.gae;

import ch.martinelli.demo.gae.model.people.Person;
import ch.martinelli.demo.gae.model.people.PersonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDataCreator implements ApplicationRunner {

    private final PersonRepository repository;
    private final String pw;

    public TestDataCreator(PersonRepository repository, @Value("${spring.datasource.password}") String pw) {
        this.repository = repository;
        this.pw = pw;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        System.out.println("PPPWWW: " + pw);

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
