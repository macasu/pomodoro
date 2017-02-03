package pomodoro.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pomodoro.excepcion.IngredienteInvalidoExcepcion;
import pomodoro.modelo.entidades.Ingrediente;
import pomodoro.modelo.enumeraciones.IngredienteCategoria;
import pomodoro.modelo.repositorio.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarIngredientes(Model model) {

		Iterable<Ingrediente> listaIngredientes = ingredienteRepositorio.findAll();
		model.addAttribute("titulo", "Lista de Ingredientes");
		model.addAttribute("ingredientes", listaIngredientes);
		model.addAttribute("categorias", IngredienteCategoria.values());
		return "ingrediente/listado";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardarIngrediente(@Valid @ModelAttribute Ingrediente ingrediente, Model model,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			throw new IngredienteInvalidoExcepcion();

		} else {
			ingredienteRepositorio.save(ingrediente);

		}

		model.addAttribute("titulo", "Lista de Ingredientes");
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		model.addAttribute("categorias", IngredienteCategoria.values());
		return "ingrediente/tabla-ingredientes";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> borrarIngrediente(@PathVariable Long id) {
		try {
			ingredienteRepositorio.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Ingrediente buscarIngrediente(@PathVariable Long id) {
		Ingrediente ingrediente = ingredienteRepositorio.findOne(id);
		return ingrediente;
	}

}
