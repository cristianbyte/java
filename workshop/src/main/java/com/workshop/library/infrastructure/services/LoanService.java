package com.workshop.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.library.api.dto.request.LoanRequest;
import com.workshop.library.api.dto.response.LoanResponse;
import com.workshop.library.domain.entities.Loan;
import com.workshop.library.domain.repositories.LoanRepository;
import com.workshop.library.infrastructure.abstract_services.ILoanService;
import com.workshop.library.utils.enums.exceptions.BadRequestException;
import com.workshop.library.utils.enums.message.ErrorMessage;
import com.workshop.library.utils.mappers.LoanMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService{

    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final LoanMapper loanMapper;

    @Override
    public LoanResponse getById(Long id) {
        Loan loan = this.find(id);
        return this.loanMapper.loanToloanResponse(loan);
    }

    @Override
    public LoanResponse create(LoanRequest request) {
        Loan loan = this.loanMapper.loanRequestToLoan(request);
        return this.loanMapper.loanToloanResponse(this.loanRepository.save(loan));
    }

    @Override
    public LoanResponse update(Long id, LoanRequest request) {
        Loan loanToUpdate = this.find(id);
        loanMapper.updateFromloanRequest(request, loanToUpdate);
        loanToUpdate.setId(id);
        return loanMapper.loanToloanResponse(loanRepository.save(loanToUpdate));
    }

    @Override
    public void delete(Long id) {
        this.loanRepository.deleteById(id);
    }

    private Loan find(Long id){
        return this.loanRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("loan")));
    }
}
