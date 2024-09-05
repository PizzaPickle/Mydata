package com.example.pkmydata.repository;

import com.example.pkmydata.entity.Mydata;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MydataRepository extends JpaRepository<Mydata, Integer>{
    Optional<Mydata> findByCustomerId(String id);
}
