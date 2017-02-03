package pomodoro.propiedadeseditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pomodoro.modelo.entidades.Ingrediente;
import pomodoro.modelo.repositorio.IngredienteRepositorio;


@Component
public class PropiedadesEditorIngredientes extends PropertyEditorSupport{
@Autowired private IngredienteRepositorio ingredienteRepositorio;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idIngrediente = Long.parseLong(text);
		Ingrediente ingrediente = ingredienteRepositorio.findOne(idIngrediente);
		setValue(ingrediente);
		
		
	
		
	}
	
}
