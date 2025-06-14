package com.example.demo.application.service;

import com.example.demo.application.dao.ClientRepository;
import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDTO> getAllClients() {
        return clientMapper.toDtoList(clientRepository.findAll());
    }

    public ClientDTO getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    public List<ClientDTO> getClientsByName(String name) {
        return clientMapper.toDtoList(clientRepository.findByName(name));
    }
}