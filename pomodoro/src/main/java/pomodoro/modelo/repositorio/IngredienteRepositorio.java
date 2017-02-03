package pomodoro.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pomodoro.modelo.entidades.Ingrediente;
@Repository
public interface IngredienteRepositorio extends CrudRepository<Ingrediente, Long>{
	
	//añadir mis método personalizados

}
