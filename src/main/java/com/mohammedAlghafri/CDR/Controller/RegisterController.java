package com.mohammedAlghafri.CDR.Controller;


import com.mohammedAlghafri.CDR.Models.Register;
import com.mohammedAlghafri.CDR.RequestObject.GetRegisterRequestObject;
import com.mohammedAlghafri.CDR.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "register")

public class RegisterController {

    @Autowired
    RegisterService registerService;


    @RequestMapping("create")
    public void saveRegister(@RequestBody GetRegisterRequestObject registerRequestObject) {
        createRegister(registerRequestObject);
    }

    @RequestMapping("get")
    public List<Register> getRegister() {
        return registerService.getRegister();
    }






    public void createRegister(GetRegisterRequestObject registerRequestObject) {

        Register register = new Register();

        register.setUsername(registerRequestObject.getUsername());
        register.setPassword(registerRequestObject.getPassword());
        register.setEmail(registerRequestObject.getEmail());
        register.setCaller_number("1234567890");
        register.setReceiver_number("9876543210");
        register.setDuration("180");
        register.setTimestamp("2023-06-16T10:30:00Z");




        register.setUpdatedDate(new Date());
        register.setCreatedDate(new Date());
        register.setIsActive(true);
        registerService.saveRegister(register);

    }


    }
























