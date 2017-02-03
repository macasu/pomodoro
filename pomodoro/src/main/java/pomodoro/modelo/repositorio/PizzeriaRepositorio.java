package pomodoro.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;

import pomodoro.modelo.entidades.Pizza;
import pomodoro.modelo.entidades.Pizzeria;

public interface PizzeriaRepositorio extends CrudRepository<Pizzeria, Long> {

	/*@Query("SELECT p FROM Pizzaria p WHERE p.usuario.login = ?")
	public Pizzeria findOneByLogin(String login);

	@Query("SELECT p1 FROM Pizzaria p1 INNER JOIN p1.pizzas p2 WHERE p2.nome = ?")
	public List<Pizzeria> listarPizzariasPorNombrePizza(String nomePizza);*/

	Iterable<Pizza> findAllByNombre(String nombrePizza);

}
