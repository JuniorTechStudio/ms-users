package com.ts.subscription.users.data.mapper;

import com.ts.subscription.users.data.entity.User;
import com.ts.subscription.users.data.dto.TelegramUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {

    @Mapping(target = "id", ignore = true)
    User mapToUser(TelegramUser telegramUser);
}
