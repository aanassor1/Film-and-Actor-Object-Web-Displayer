package mainPackage.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mainPackage.Hw1Application;
import mainPackage.domain.Film;

@Controller
public class FilmController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new FilmValidator());
	}
	
	@GetMapping("/films")
	public String films(Model model) {
		model.addAttribute("films", Hw1Application.films);
		return "films/list";
	}
	
	@RequestMapping("/newFilm")
	public String newAgent(Model model) {
		model.addAttribute("film", new Film());
		return "films/form";
	}
	
	@PostMapping("/addFilm")
	public String addFilm(@Valid @ModelAttribute Film film, BindingResult result) {
		if (result.hasErrors()) {
			return "films/form";
		}
		Hw1Application.films.add(film);
		return "redirect:/films";
	}
	
}
