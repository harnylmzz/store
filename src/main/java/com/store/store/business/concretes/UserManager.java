package com.store.store.business.concretes;

import com.store.store.business.abstracts.UserService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.user.CreateUserRequest;
import com.store.store.dto.requests.user.DeleteUserRequest;
import com.store.store.dto.requests.user.UpdateUserRequest;
import com.store.store.dto.responses.user.GetAllUserResponses;
import com.store.store.dto.responses.user.GetByIdUserResponses;
import com.store.store.model.User;
import com.store.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<GetAllUserResponses>> getAll() {

        List<User> users = userRepository.findAll();
        List<GetAllUserResponses> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllUserResponses, true, "Users listed successfully.");
    }

    @Override
    public DataResult<GetByIdUserResponses> getById(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found."));

        GetByIdUserResponses getByIdUserResponses = this.modelMapperService.forResponse()
                .map(user, GetByIdUserResponses.class);

        return new DataResult<>(getByIdUserResponses, true, "User listed successfully.");
    }

    @Override
    public Result add(CreateUserRequest createUserRequest) {

        User user = this.modelMapperService.forRequest()
                .map(createUserRequest, User.class);

        this.userRepository.save(user);

        return new SuccessResult("User added successfully.");
    }

    @Override
    public Result update(UpdateUserRequest updateUserRequest) {

        User user = this.modelMapperService.forRequest()
                .map(updateUserRequest, User.class);

        user.setId(updateUserRequest.getId());
        user.setEmail(updateUserRequest.getEmail());
        user.setPassword(updateUserRequest.getPassword());

        this.userRepository.save(user);
        return null;
    }

    @Override
    public Result delete(DeleteUserRequest deleteUserRequest) {

        User user = this.modelMapperService.forRequest()
                .map(deleteUserRequest, User.class);

        this.userRepository.delete(user);

        return new SuccessResult("User deleted successfully.");
    }
}
