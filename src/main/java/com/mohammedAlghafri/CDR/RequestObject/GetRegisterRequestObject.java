package com.mohammedAlghafri.CDR.RequestObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetRegisterRequestObject {
    String username;

    String password;

    String email;


}
