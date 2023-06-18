package com.mohammedAlghafri.CDR.Service;

import com.mohammedAlghafri.CDR.Models.Register;
import com.mohammedAlghafri.CDR.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    public List<Register> getRegister() {return registerRepository.findAll();
    }
    public void saveRegister(Register register) {registerRepository.save(register); }

}