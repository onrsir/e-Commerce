package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.business.requests.CreateUserRequest;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;

import java.util.List;

public interface UserService {

    void add(CreateUserRequest createUserRequest);

    List<GetAllUserResponse> getAll();
}
