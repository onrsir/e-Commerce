package com.onursir.eCommerce.business.services;


import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateUserRequest;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.dataAccess.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private ModelMappersService modelMappersService;
    private UserRepository userRepository;

    @Override
    public void add(CreateUserRequest createUserRequest) {

        User user = this.modelMappersService.forRequest().map(createUserRequest,User.class);
        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUserResponse> getAll() {

        List<User> users = userRepository.findAll();

        List<GetAllUserResponse> userResponses = users.stream()
                .map(userItem -> this.modelMappersService.forResponse()
                        .map(userItem,GetAllUserResponse.class)).collect(Collectors.toList());

        return userResponses;
    }




}
