package com.example.recognition.controller;

import com.example.recognition.service.LicenseService;
import com.example.recognition.vehicle.bean.Car;
import com.example.recognition.vehicle.bean.CarLicense;
import com.example.recognition.vehicle.bean.CarResponse;
import com.example.recognition.vehicle.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.recognition.face.bean.FacePicture;
import com.example.recognition.face.bean.PersonResponse;
import com.example.recognition.face.entity.Rlbdjg;
import com.example.recognition.service.FaceService;

@RestController
@Validated
@RequestMapping("")
public class FaceController {

	@Autowired
	FaceService faceService;
	@Autowired
	private LicenseService licenseService;

	@RequestMapping(value = "/face", method = RequestMethod.POST)
	public PersonResponse getInfo(@RequestBody FacePicture facePicture,float minSimilarity) {
		return faceService.putFace(facePicture,minSimilarity);
	}
	@RequestMapping(value = "/getcar", method = RequestMethod.POST)
	public Vehicle getCar(@RequestParam String HPHM1)
    {
//         System.out.println("ok"+licenseService.getCar(HPHM1).getHPHM1());
		return licenseService.getCar(HPHM1);
	}
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public Rlbdjg getPerson() {
		return faceService.getPerson();
	}
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public String getInfo() {
		return "success";
	}

}
