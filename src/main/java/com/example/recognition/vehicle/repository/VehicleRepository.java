package com.example.recognition.vehicle.repository;



import com.example.recognition.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	@NonNull
	Vehicle findByHPHM1(@NonNull String HPHM1);
}
