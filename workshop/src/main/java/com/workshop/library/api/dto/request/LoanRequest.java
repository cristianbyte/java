package com.workshop.library.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    @FutureOrPresent(message = "future or present")
    private LocalDateTime loanDate;
    @Future(message = "Return date must be in the future")
    private LocalDateTime returnDate;

    @Pattern(regexp = "ACTIVE|INACTIVE", message = "Status must be either 'ACTIVE' or 'INACTIVE'")
    private String status;
    @NotNull(message = "User ID cannot be null")
    private Long user_id;
    @NotNull(message = "Book ID cannot be null")
    private Long book_id;
}
