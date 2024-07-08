package com.workshop.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.library.api.dto.request.UserRequest;
import com.workshop.library.api.dto.response.UserOnlyLoans;
import com.workshop.library.api.dto.response.UserOnlyReservations;
import com.workshop.library.api.dto.response.UserResponse;
import com.workshop.library.api.dto.response.UserResponseFull;
import com.workshop.library.domain.entities.User;
import com.workshop.library.domain.repositories.UserRepository;
import com.workshop.library.infrastructure.abstract_services.IUserService;
import com.workshop.library.utils.enums.exceptions.BadRequestException;
import com.workshop.library.utils.enums.message.ErrorMessage;
import com.workshop.library.utils.mappers.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserResponseFull getById(Long id) {
        return this.userMapper.entityToResponseFull(this.findById(id));
    }

    @Override
    public UserResponse createNew(UserRequest request) {
        User userToCreate = this.userMapper.requestToEntity(request);
        User userSaved = this.userRepository.save(userToCreate);
        return this.userMapper.entityToResponse(userSaved);
    }

    @Override
    public UserResponseFull update(Long id, UserRequest request) {
        this.findById(id);
        User userToUpdate = this.userMapper.requestToEntity(request);
        userToUpdate.setId(id);
        User userSaved = this.userRepository.save(userToUpdate);
        return this.userMapper.entityToResponseFull(userSaved);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        this.userRepository.deleteById(id);
    }
    
    @Override
    public UserOnlyLoans getUserLoans(Long id) {
        return this.userMapper.entityToResponseLoans(this.findById(id));
    }

    @Override
    public UserOnlyReservations getUserReservations(Long id) {
        return this.userMapper.entityToResponseReservations(this.findById(id));
    }
    
    private User findById(Long id){
        return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
    }

    @Override
    public UserResponseFull create(UserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    
}
