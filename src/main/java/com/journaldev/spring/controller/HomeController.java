package com.journaldev.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;


import com.journaldev.spring.model.User;

@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		
		WebClient client = WebClient.create("https://assign3userservice.azurewebsites.net/");


		User response = client.get().uri("/user?id=" + user.getId())
						.exchange()
                               .block()
                               .bodyToMono(User.class)
                               .block();
		model.addAttribute("userName", response.getName());
		return "user";
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.POST)
	public String inventory(@Validated User user, Model model) {
		
		WebClient client = WebClient.create("https://assign3inventoryservice.azurewebsites.net/");


		String response = client.get().uri("/inventory?userid=" + user.getId())
						.exchange()
                               .block()
                               .bodyToMono(String.class)
                               .block();
		model.addAttribute("stuff", response);
		return "inventory";
	}
}
