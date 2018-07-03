package service.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import service.business.Rate;
import service.business.Transaction;
import service.repositories.Transactionrepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	public static final String DOMAIN = "ms-taux";
	public static final String PORT   = "8001";
	public static final String WEBSERVICE = "taux-change";
	
	public static final String PARAM_SRC = "src";
	public static final String PARAM_DST = "dst";
	public static final String PARAM_DATE = "date";
	
	@Autowired
	private Transactionrepository rep;
	
	@GetMapping("/{id}")
	public Transaction getTransactionById(@PathVariable long id) {
		return rep.getOne(id);
	}
	
	@PostMapping("/")
	public Transaction createTransaction(@Valid @RequestBody Transaction transactionDetails) {
		RestTemplate rest = new RestTemplate();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String rateUrl = "http://" + DOMAIN +
						":" + PORT + "/" + 
						WEBSERVICE + "/" +
						PARAM_SRC + "/" + transactionDetails.getSrc() + "/" +
						PARAM_DST + "/" + transactionDetails.getDst() + "/" +
						PARAM_DATE + "/" + format.format(transactionDetails.getDate());

		/*String rateUrl = "http://mstaux:8001/taux-change/src/" +
				transactionDetails.getSrc() + "/dst/" +
				transactionDetails.getDst() + "/date/" +
				format.format(transactionDetails.getDate());*/
		
		Rate rate = rest.getForObject(rateUrl, Rate.class);
		transactionDetails.setTaux(rate.getTaux());
		return rep.save(transactionDetails);

	}
	
	@PutMapping("/{id}")
	public Transaction updateTransaction(@PathVariable long id, 
			@Valid @RequestBody Transaction transactionDetails)
	{
		Transaction transaction = rep.getOne(id);
		
		transaction.setDate(transactionDetails.getDate());
		transaction.setDst(transactionDetails.getDst());
		transaction.setMontant(transactionDetails.getMontant());
		transaction.setSrc(transactionDetails.getSrc());
		transaction.setTaux(transactionDetails.getTaux());
		
		Transaction updatedTransaction = rep.save(transaction);
		return updatedTransaction;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable long id){
	
		Transaction transaction = rep.getOne(id);
		
		rep.delete(transaction);
		return ResponseEntity.ok().build();
	}
	
	
}
