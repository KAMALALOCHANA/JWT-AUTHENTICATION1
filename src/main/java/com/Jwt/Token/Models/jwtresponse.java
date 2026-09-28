package com.Jwt.Token.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class jwtresponse {

    private String jwtToken;

    private String username;

}
