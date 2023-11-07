package com.ts.subscription.users.data.mapper;

import com.ts.subscription.users.data.dto.UserCreateRequest;
import com.ts.subscription.users.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isBlocked", ignore = true)
    User mapToUser(UserCreateRequest request);

}
