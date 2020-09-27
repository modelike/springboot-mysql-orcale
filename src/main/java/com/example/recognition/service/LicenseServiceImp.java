package com.example.recognition.service;


import com.example.recognition.face.entity.VeInfo;
import com.example.recognition.face.repository.VeInfoRepository;
import com.example.recognition.vehicle.entity.Vehicle;
import com.example.recognition.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LicenseServiceImp implements LicenseService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VeInfoRepository veInfoRepository;

    @Override
    @Transactional("vehicleTransactionManager")
    public Vehicle getCar(String HPHM1) {
        VeInfo veInfo=new VeInfo();
        Vehicle v=vehicleRepository.findByHPHM1(HPHM1);
//        veInfo.setId("1");
        veInfo.setLicense(HPHM1);
        veInfo.setName(v.getSYR());
        veInfo.setType(v.getCLPP1());
//        System.out.println(veInfo);
       veInfoRepository.save(veInfo);
        return v;
    }
	
}
