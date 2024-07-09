package com.example.log4j2custom.repo;

import com.example.log4j2custom.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {

}
