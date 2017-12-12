package com.travel.farecontroller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//controller module that accepts parameters from client side test modification
@Controller
public class FareController {

	@Resource
	private IFareService fareService;

	@ModelAttribute
	protected void addingCommonObject(Model model1) {
		model1.addAttribute("headerMsg", "Charly Taxi: Imperial Taxi Services");
	}

	@RequestMapping(value = "/FareForm.html", method = RequestMethod.GET)
	protected ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("FareForm");
		return modelAndView;
	}

	// submited form
	@RequestMapping(value = "/submitFareForm.html", method = RequestMethod.POST)
	protected ModelAndView submitAdmissionForm(@RequestParam("rideDistance") Long distance,
			@RequestParam("waitingTime") int waitingTime, @RequestParam("nbSuit") int nbSuit,
			@RequestParam(value = "nightSup", required = false) boolean nightSup,
			@RequestParam(value = "regClient", required = false) boolean regClient,
			@RequestParam("nbOfNights") int numberOfNights, @RequestParam("breakfast") boolean breakfast,
			@RequestParam("hotelRank") int hotelRank,
			@RequestParam(value = "discountCode", required = false) String discountCode) {

		ModelAndView modelAndView = new ModelAndView("FareResult");

		double fare = fareService.calculateTravelFare(distance, waitingTime, nbSuit, numberOfNights, breakfast, true, regClient,
				hotelRank, discountCode);
		modelAndView.addObject("fare", fare);
		modelAndView.addObject("date", new Date());

		return modelAndView;
	}

	public void getBestPrice() {
		System.out.println("test");
	}
}
