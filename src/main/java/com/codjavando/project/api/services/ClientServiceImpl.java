package com.codjavando.project.api.services;

import com.codjavando.project.api.model.Client;
import com.codjavando.project.api.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Client save(Client client) {
        client.setDate(LocalDate.now());
        return repository.save(client);
    }
}
