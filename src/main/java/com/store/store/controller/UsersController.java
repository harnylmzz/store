package com.store.store.controller;

import com.store.store.business.abstracts.UserService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.user.CreateUserRequest;
import com.store.store.dto.requests.user.DeleteUserRequest;
import com.store.store.dto.requests.user.UpdateUserRequest;
import com.store.store.dto.responses.user.GetAllUserResponses;
import com.store.store.dto.responses.user.GetByIdUserResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllUserResponses>> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdUserResponses> getById(int id) {
        return this.userService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return this.userService.add(createUserRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateUserRequest updateUserRequest) {
        return this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteUserRequest deleteUserRequest) {
        return this.userService.delete(deleteUserRequest);
    }
}
