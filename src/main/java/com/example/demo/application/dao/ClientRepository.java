package com.example.demo.application.dao;

import com.example.demo.application.resource.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @EntityGraph(value = "Client.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<Client> findAll();

    @EntityGraph(value = "Client.detail", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Client> findById(Long id);

    @EntityGraph(value = "Client.detail", type = EntityGraph.EntityGraphType.LOAD)
    List<Client> findByName(String name);
}