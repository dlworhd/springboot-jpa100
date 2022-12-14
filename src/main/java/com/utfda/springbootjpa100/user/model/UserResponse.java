package com.utfda.springbootjpa100.user.model;

import com.utfda.springbootjpa100.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    private String username;
    private String phone;

    public static UserResponse of(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .id(user.getId())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
