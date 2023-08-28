package com.example.validatingforminput;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {

	List<Person> persons = new ArrayList<>();

	@RequestMapping("/results")
	public String results(ModelMap model) {
		model.addAttribute("results", persons);
		return "results";
	}
	// parameter `person` is shown as unused in these methods,
	// the `person` model attribute is not resolved in view
	// IDEA-132329

	@GetMapping("/")
	public String showForm(Person person) {
		return "person_form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid Person person
			                      , BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "person_form";
		}
       // parameter should be shown as unused if you coment-out this line:
		//persons.add(person);
		return "redirect:/results";
	}
}