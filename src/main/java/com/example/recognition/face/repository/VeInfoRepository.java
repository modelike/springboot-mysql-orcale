package com.example.recognition.face.repository;

import com.example.recognition.face.entity.VeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeInfoRepository extends CrudRepository<VeInfo, String> {
}
