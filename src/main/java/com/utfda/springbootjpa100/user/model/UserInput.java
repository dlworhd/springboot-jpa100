package com.utfda.springbootjpa100.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInput {

    @NotBlank(message = "아이디는 필수 항목입니다.")
    public String username;

    @Email(message = "이메일 형식에 맞게 입력해주세요.")
    @NotBlank(message = "이메일은 필수 항목입니다.")
    public String email;

    @Size(min = 4, message = "비밀번호는 4자 이상 입력해주세요.")
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    public String password;

    @Size(max = 20, message = "전화번호는 최대 20자리까지만 입력해주세요.")
    @NotBlank(message = "전화번호는 필수 항목입니다.")
    public String phone;

}
