package com.springboot.app.loans.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.loans.models.Loan;
import com.springboot.app.users.models.User;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	Page<Loan> findByUser(User user, Pageable pageable);
}
