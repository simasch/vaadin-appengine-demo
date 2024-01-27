package ch.martinelli.demo.gae.views.people;

import ch.martinelli.demo.gae.model.people.Person;
import ch.martinelli.demo.gae.model.people.PersonRepository;
import ch.martinelli.demo.gae.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("People")
@Route(value = "people", layout = MainLayout.class)
public class PeopleView extends VerticalLayout {

    public PeopleView(PersonRepository repository) {
        var peopleGrid = new Grid<>(Person.class);

        peopleGrid.setItems(repository.findAll());

        add(peopleGrid);
    }
}
