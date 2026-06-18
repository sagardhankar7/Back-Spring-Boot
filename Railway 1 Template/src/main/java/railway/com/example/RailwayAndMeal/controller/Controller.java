package railway.com.example.RailwayAndMeal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.service.RailwayService;

@RestController
@RequestMapping("/railway")
public class Controller {

	@Autowired
	private RailwayService railwayservice;		
	

	// a. POST "/railway/ticket":  It saves a railway ticket.
	@PostMapping("/ticket")
	public void addTicket(@RequestBody Ticket ticket) {

		railwayservice.addTicket(ticket);
		/**
	 1. Call the required service method
	 2. Add proper annotations for Post Mapping and attaching the
	 RequestBody.
	 **/
	}


	// b. GET "/railway/tickets": It fetches the list of all tickets.
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return railwayservice.getAllTickets();
	/**
	 1. Call the required service method
	 2. Add proper annotations for Get Mapping.
	 **/
//		return null;
	}
	

	// c. GET "/railway/ticket/{pnr}": It retrieves a specific ticket through the pnr number.
	@GetMapping("/ticket/{pnr}")
	public Ticket getTicketByPnr(@PathVariable long pnr) {
		return railwayservice.getTicketByPnr(pnr);
		/**
	 1. Call the required service method.
	 2. Add proper annotations for Get Mapping and attaching the
	 Path Variable to the method parameter.
	 **/
//		return null;
	}	

}
