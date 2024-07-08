package com.workshop.library.infrastructure.abstract_services;

import com.workshop.library.api.dto.request.UserRequest;
import com.workshop.library.api.dto.response.UserOnlyLoans;
import com.workshop.library.api.dto.response.UserOnlyReservations;
import com.workshop.library.api.dto.response.UserResponse;
import com.workshop.library.api.dto.response.UserResponseFull;

public interface IUserService extends CrudAbstractService<UserRequest, UserResponseFull, Long>{
    public UserOnlyLoans getUserLoans(Long id);
    public UserOnlyReservations getUserReservations(Long id);
    public UserResponse createNew(UserRequest reqeust);
}
