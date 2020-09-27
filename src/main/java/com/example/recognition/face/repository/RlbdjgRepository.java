package com.example.recognition.face.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.recognition.face.entity.Rlbdjg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlbdjgRepository extends CrudRepository<Rlbdjg, String> {

	@Query(value = "select t from Rlbdjg t ORDER BY t.time DESC")
	List<Rlbdjg> listRlbdjg();
}
