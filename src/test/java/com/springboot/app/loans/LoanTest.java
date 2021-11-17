package com.springboot.app.loans;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.app.loans.models.Loan;
import com.springboot.app.loans.repository.LoanRepository;

@DataJpaTest
class LoanTest {

	@Autowired
    private LoanRepository loanRepository;
	
	@Test
	void testAllLoans() {
		List<Loan> loans = (List<Loan>) loanRepository.findAll();
	    assertThat(loans).size().isGreaterThan(0);
	}

}
