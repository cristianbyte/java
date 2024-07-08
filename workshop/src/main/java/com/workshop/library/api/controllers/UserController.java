package com.workshop.library.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.library.api.dto.request.UserRequest;
import com.workshop.library.api.dto.response.UserOnlyLoans;
import com.workshop.library.api.dto.response.UserOnlyReservations;
import com.workshop.library.api.dto.response.UserResponse;
import com.workshop.library.api.dto.response.UserResponseFull;
import com.workshop.library.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private final IUserService userService;

    @GetMapping(path = "/{user_id}")
    public ResponseEntity<UserResponseFull> get(@PathVariable(name = "user_id") Long id){
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @GetMapping(path = "/{id}/loans")
    public ResponseEntity<UserOnlyLoans> getOnlyLoans(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(this.userService.getUserLoans(id));
    }

    @GetMapping(path = "/{id}/reservations")
    public ResponseEntity<UserOnlyReservations> getOnlyReservations(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(this.userService.getUserReservations(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(UserRequest request){
        return ResponseEntity.ok(this.userService.createNew(request));
    }

    @PutMapping(path = "/{user_id}")
    public ResponseEntity<UserResponseFull> update(@PathVariable(name = "user_id") Long id, UserRequest request){
        return ResponseEntity.ok(this.userService.update(id, request));
    }

    @DeleteMapping(path = "/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "user_id") Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
