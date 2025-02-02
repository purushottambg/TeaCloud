package com.teaCloud.dtos;

import lombok.*;

@Data
@Getter
@Setter
public class LogInDTO {
    public Long  memberID;
    public String password;
}
