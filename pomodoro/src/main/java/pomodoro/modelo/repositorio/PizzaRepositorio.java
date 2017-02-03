package pomodoro.modelo.repositorio;



import java.util.List;

import org.springframework.data.repository.CrudRepository;


import pomodoro.modelo.entidades.Pizza;
import pomodoro.modelo.entidades.Pizzeria;



public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {

	List<Pizza> findAllByDono(Pizzeria dono);

	Pizza findByIdAndDono(Long id, Pizzeria dono);

	List<Pizza> findAll();
	



	

}
