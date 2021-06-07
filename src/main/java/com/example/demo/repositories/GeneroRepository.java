package com.example.demo.repositories;

import com.example.demo.models.GeneroModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends CrudRepository<GeneroModel, Long> {

}
