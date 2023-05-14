package com.example.Book.my.show.Backend.project.Controllers;

import com.example.Book.my.show.Backend.project.Dtos.TicketDTO;
import com.example.Book.my.show.Backend.project.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("book_ticket")
    public ResponseEntity<String> bookTicket(@RequestBody() TicketDTO ticketDTO) throws Exception {
        try{
            ticketService.BookTickets(ticketDTO);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Congratulations ! your tickets has been booked Successfully" , HttpStatus.OK);

    }
    @DeleteMapping("cancel_ticket")
    public ResponseEntity<String> cancelTicket(@RequestParam("Id") int ticketId){
        int refund=ticketService.cancelTicket(ticketId);
        return new ResponseEntity<>("You have cancelled your tickets,Your refund amount is" + " " + refund,HttpStatus.OK);
    }
}
