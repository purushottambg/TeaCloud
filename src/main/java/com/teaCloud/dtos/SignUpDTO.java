package com.teaCloud.dtos;

import lombok.*;
import javax.persistence.Column;

@Data
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class SignUpDTO {

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "age")
    private Integer age;

    @Column(unique = true)
    private String email;

    @Column(name="department")
    private String department;

    private String password;
}
