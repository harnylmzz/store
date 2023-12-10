package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.user.CreateUserRequest;
import com.store.store.dto.requests.user.DeleteUserRequest;
import com.store.store.dto.requests.user.UpdateUserRequest;
import com.store.store.dto.responses.user.GetAllUserResponses;
import com.store.store.dto.responses.user.GetByIdUserResponses;

import java.util.List;

public interface UserService {

    DataResult<List<GetAllUserResponses>> getAll();

    DataResult<GetByIdUserResponses> getById(int id);

    Result add(CreateUserRequest createUserRequest);

    Result update(UpdateUserRequest updateUserRequest);

    Result delete(DeleteUserRequest deleteUserRequest);

}
