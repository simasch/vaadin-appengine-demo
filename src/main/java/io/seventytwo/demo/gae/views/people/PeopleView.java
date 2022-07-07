package io.seventytwo.demo.gae.views.people;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.seventytwo.demo.gae.model.people.Person;
import io.seventytwo.demo.gae.model.people.PersonRepository;
import io.seventytwo.demo.gae.views.MainLayout;

@PageTitle("People")
@Route(value = "people", layout = MainLayout.class)
public class PeopleView extends VerticalLayout {

    public PeopleView(PersonRepository repository) {
        Grid<Person> peopleGrid = new Grid<>(Person.class);

        peopleGrid.setItems(repository.findAll());

        add(peopleGrid);
    }
}
