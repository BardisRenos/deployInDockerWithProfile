package com.example.demo.application.controller;

import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/search")
    public List<ClientDTO> getClientsByName(@RequestParam String name) {
        return clientService.getClientsByName(name);
    }
}
