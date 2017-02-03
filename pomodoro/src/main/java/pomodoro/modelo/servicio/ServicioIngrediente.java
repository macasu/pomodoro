package pomodoro.modelo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pomodoro.modelo.entidades.Ingrediente;
import pomodoro.modelo.repositorio.IngredienteRepositorio;

@Service
public class ServicioIngrediente {
	@Autowired private IngredienteRepositorio repositorio;
	public Iterable<Ingrediente> listar(){
		
		return repositorio.findAll();
	}
	
	
}
