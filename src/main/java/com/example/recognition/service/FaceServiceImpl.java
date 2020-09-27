package com.example.recognition.service;

import java.util.Date;
import java.util.List;

import com.example.recognition.face.bean.FaceQueryByImageModelWithPage;
import com.example.recognition.face.bean.Person;
import com.example.recognition.face.bean.PersonResponse;
import com.example.recognition.face.bean.QueryByImageModelWithPageRequest;
import com.example.recognition.face.repository.RlbdjgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.example.recognition.face.bean.FacePicture;
import com.example.recognition.face.entity.Rlbdjg;

@Service
public class FaceServiceImpl implements FaceService {

	@Autowired
	private RlbdjgRepository rlbdjgRepository;

	@Override
	public PersonResponse putFace(FacePicture facePicture, float minSimilarity) {
		// TODO Auto-generated method stub
	//	ActionResponse response = new ActionResponse();
		PersonResponse personResponse = new PersonResponse();
		try {
			// 组织请求参数
			QueryByImageModelWithPageRequest request = new QueryByImageModelWithPageRequest();
			request.setPageNo(1);
			request.setPageSize(20);
			request.setPersonLibId("1592822720904");
			request.setImageData(facePicture.getFaceString());
			request.setMinSimilarity(minSimilarity);
			// 查询返回结果
			String resultString = FaceQueryByImageModelWithPage.queryByImageModelWithPage(request);
			System.out.println("结果：" + resultString);
			// 将返回结果转化为对象
			personResponse = JSONObject.parseObject(resultString, PersonResponse.class);
			// 相似度最高的某个人
			if (!personResponse.getData().getList().isEmpty()) {
				Person person = personResponse.getData().getList().get(0);
				Rlbdjg rlbdjg = new Rlbdjg();
				rlbdjg.setName(person.getName());
				rlbdjg.setSfzId(person.getCertificateNumber());
				rlbdjg.setYstp(facePicture.getFaceString());
				rlbdjg.setBdtp(person.getFacePicUrl());
				rlbdjg.setSimilarity(person.getSimilarity());
				rlbdjg.setTime(new Date());
				rlbdjgRepository.save(rlbdjg);
			}

//			Rlbdjg rlbdjg = new Rlbdjg();
//			rlbdjg.setName("1");
//			rlbdjg.setSfzId("1");
//			rlbdjg.setYstp("1");
//			rlbdjg.setBdtp("1");
//			rlbdjg.setSimilarity((float)0.9);
//			rlbdjg.setTime(new Date());
//			rlbdjgRepository.save(rlbdjg);
//			System.out.println("success");
//			response.setCode(personResponse.getCode());
//			response.setResult(personResponse.getMsg());

		} catch (Exception e) {
			System.out.println(e.getMessage());
//			response.setCode("500");
//			response.setResult(e.getMessage());
			return personResponse;
		}
		return personResponse;
	}

	@Override
	public Rlbdjg getPerson() {
		// TODO Auto-generated method stub
		List<Rlbdjg> persons = rlbdjgRepository.listRlbdjg();
		if (!persons.isEmpty()) {
			return persons.get(0);
		}
		return null;
	}

}
