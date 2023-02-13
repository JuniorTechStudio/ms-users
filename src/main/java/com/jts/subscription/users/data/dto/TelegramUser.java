package com.jts.subscription.users.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelegramUser {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private boolean isBlocked;
}

