package com.workshop.library.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.workshop.library.utils.enums.StatusType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanResponse {

    private Long id;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
    private StatusType status;
    private Long user_id;
    private Long book_id;
}
