package com.jts.subscription.users.data.mapper;

import com.jts.subscription.users.data.entity.User;
import com.jts.subscription.users.data.telegram.TelegramUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {

    @Mapping(target = "id", ignore = true)
    User mapToUser(TelegramUser telegramUser);
}
