package com.springboot.app.loans.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.loans.models.Loan;
import com.springboot.app.loans.repository.LoanRepository;
import com.springboot.app.users.models.User;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;

	@GetMapping("")
	public ResponseEntity<Map<String, Object>> allLoans(@RequestParam int page, @RequestParam int size,
			@RequestParam(required = false, name = "user_id") User user) {
		Pageable paging = PageRequest.of(page, size);

		Page<Loan> pageLoans;
		
		if (user == null) {
			pageLoans = loanRepository.findAll(paging);
		} else {
			pageLoans = loanRepository.findByUser(user, paging);
		}

		Map<String, Object> items = new HashMap<>();
		items.put("items", pageLoans.getContent());

		LinkedHashMap<String, Object> pageInfo = new LinkedHashMap<String, Object>();
		pageInfo.put("page", pageLoans.getNumber());
		pageInfo.put("size", pageLoans.getSize());
		pageInfo.put("total", pageLoans.getTotalElements());

		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("items", pageLoans.getContent());
		response.put("paging", pageInfo);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
