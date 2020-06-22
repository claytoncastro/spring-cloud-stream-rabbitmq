package com.codjavando.project.api.services;

import com.codjavando.project.api.model.Client;
import com.codjavando.project.api.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Client save(Client client) throws Exception {
        if(!emailNoExist(client.getEmail())) {
            throw new Exception("The email " + client.getEmail() +
                    " is already registered. Please register an email not yet registered!");
        }

        client.setDate(LocalDate.now());
        return repository.save(client);
    }

    public boolean emailNoExist(String email) {
        return repository.findAll().stream()
                .filter(c -> email.equals(c.getEmail()))
                .collect(Collectors.toList())
                .isEmpty();
    }
}
