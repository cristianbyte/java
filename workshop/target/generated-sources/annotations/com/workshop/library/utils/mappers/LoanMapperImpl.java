package com.workshop.library.utils.mappers;

import com.workshop.library.api.dto.request.LoanRequest;
import com.workshop.library.api.dto.response.LoanResponse;
import com.workshop.library.domain.entities.Book;
import com.workshop.library.domain.entities.Loan;
import com.workshop.library.domain.entities.User;
import com.workshop.library.utils.enums.StatusType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:17:31-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public Loan loanRequestToLoan(LoanRequest request) {
        if ( request == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.user( loanRequestToUser( request ) );
        loan.book( loanRequestToBook( request ) );
        loan.loanDate( request.getLoanDate() );
        loan.returnDate( request.getReturnDate() );
        if ( request.getStatus() != null ) {
            loan.status( Enum.valueOf( StatusType.class, request.getStatus() ) );
        }

        return loan.build();
    }

    @Override
    public LoanResponse loanToloanResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.user_id( loanUserId( loan ) );
        loanResponse.book_id( loanBookId( loan ) );
        loanResponse.id( loan.getId() );
        loanResponse.loanDate( loan.getLoanDate() );
        loanResponse.returnDate( loan.getReturnDate() );
        loanResponse.status( loan.getStatus() );

        return loanResponse.build();
    }

    @Override
    public void updateFromloanRequest(LoanRequest request, Loan loan) {
        if ( request == null ) {
            return;
        }

        loan.setLoanDate( request.getLoanDate() );
        loan.setReturnDate( request.getReturnDate() );
        if ( request.getStatus() != null ) {
            loan.setStatus( Enum.valueOf( StatusType.class, request.getStatus() ) );
        }
        else {
            loan.setStatus( null );
        }
    }

    protected User loanRequestToUser(LoanRequest loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( loanRequest.getUser_id() );

        return user;
    }

    protected Book loanRequestToBook(LoanRequest loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( loanRequest.getBook_id() );

        return book;
    }

    private Long loanUserId(Loan loan) {
        if ( loan == null ) {
            return null;
        }
        User user = loan.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long loanBookId(Loan loan) {
        if ( loan == null ) {
            return null;
        }
        Book book = loan.getBook();
        if ( book == null ) {
            return null;
        }
        Long id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
