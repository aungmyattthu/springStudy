package com.amt.helloworld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amt.helloworld.entity.Division;

public interface DivisionRepo extends JpaRepository<Division, Integer>{

}
