package pomodoro.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pomodoro.modelo.repositorio.PizzaRepositorio;
import pomodoro.modelo.repositorio.PizzeriaRepositorio;



@Controller
@RequestMapping("/pizzerias")
public class PizzeriaController {
	@Autowired private PizzeriaRepositorio servicoPizzaria;
	@Autowired private PizzaRepositorio servicoPizza;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("nombresPizzas", servicoPizza.findAll());
		return "cliente/busca_pizzarias";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/pizza/{nomePizza}")
	public String index(@PathVariable String nomePizza, Model model){
		model.addAttribute("pizzarias", servicoPizzaria.findAllByNombre(nomePizza));
		return "cliente/tabela_pizzarias";
	}

}
