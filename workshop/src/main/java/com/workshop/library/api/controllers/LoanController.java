package com.workshop.library.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.library.api.dto.request.LoanRequest;
import com.workshop.library.api.dto.response.LoanResponse;
import com.workshop.library.infrastructure.abstract_services.ILoanService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/loans")
@AllArgsConstructor
@Tag(name="Loans")
public class LoanController {
  @Autowired
  private final ILoanService loanService;
  
  //creating a loan
  @PostMapping
  public ResponseEntity<LoanResponse> create(@RequestBody LoanRequest request){
    return ResponseEntity.ok(this.loanService.create(request));
  }
  // get information about a loan
  @GetMapping(path = "/{loan_id}")
  public ResponseEntity<LoanResponse> getInfo(@PathVariable Long loan_id) {
      return ResponseEntity.ok(this.loanService.getById(loan_id));
  }

  //update a loan
  @PutMapping(path = "/{loan_id}")
  public ResponseEntity<LoanResponse> update(@PathVariable Long loan_id, @Validated @RequestBody LoanRequest request) {
      return ResponseEntity.ok(this.loanService.update(loan_id, request));
  }

  // delete a loan
  @DeleteMapping(path = "/{loan_id}")
  public ResponseEntity<Void> delete(@PathVariable Long loan_id) {
      this.loanService.delete(loan_id);
      return ResponseEntity.noContent().build();
  }
}
