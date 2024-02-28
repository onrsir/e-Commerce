package com.onursir.eCommerce.webAPI;

import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.requests.CreateUserRequest;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.business.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Add")
    public void add(CreateUserRequest createUserRequest){
        userService.add(createUserRequest);
    }

    @GetMapping
    @Operation(summary = "Get All")
    public List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }


}
