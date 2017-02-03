package pomodoro.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pomodoro.excepcion.IngredienteInvalidoExcepcion;
import pomodoro.modelo.entidades.Ingrediente;
import pomodoro.modelo.entidades.Pizza;
import pomodoro.modelo.enumeraciones.PizzaCategoria;
import pomodoro.modelo.repositorio.IngredienteRepositorio;
import pomodoro.modelo.repositorio.PizzaRepositorio;
import pomodoro.propiedadeseditor.PropiedadesEditorIngredientes;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	@Autowired
	private PropiedadesEditorIngredientes ingredientePropertyEditor;
	@Autowired
	private PizzaRepositorio pizzaRepositorio;
	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPizzas(Model model) {

		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("categorias", PizzaCategoria.values());
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		return "pizza/listado";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarPizza(@Valid @ModelAttribute Pizza pizza, Model model, BindingResult bindingResult)

	{

		/*if (bindingResult.hasErrors()) {
			throw new IngredienteInvalidoExcepcion();

		} else {
			pizzaRepositorio.save(pizza);

		}*/
		
		try{
			pizzaRepositorio.save(pizza);
		}catch(Exception e){
			e.printStackTrace();
		}

		
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("categorias", PizzaCategoria.values());
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		return "pizza/tabla-pizzas";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletarPizza(@PathVariable Long pizzaId) {
		try {
			pizzaRepositorio.delete(pizzaId);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{pizzaId}")
	public ResponseEntity<Pizza> buscarPizza(@PathVariable Long pizzaId) {
		Pizza pizza = pizzaRepositorio.findOne(pizzaId);
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}

}
