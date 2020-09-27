package com.example.recognition.service;

import com.example.recognition.face.bean.FacePicture;
import com.example.recognition.face.bean.PersonResponse;
import com.example.recognition.face.entity.Rlbdjg;

public interface FaceService {
	
	public PersonResponse putFace(FacePicture facePicture, float minSimilarity);
	
	public Rlbdjg getPerson(); 
	
}
