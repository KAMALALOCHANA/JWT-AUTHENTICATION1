package com.Jwt.Token.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Jwtrequest {

    private String email;
    private String password;
}
