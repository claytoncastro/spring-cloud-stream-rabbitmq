package com.codjavando.project.api.resources;

import com.codjavando.project.api.model.Client;
import com.codjavando.project.api.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientResource {

    private final ClientService service;

    @PostMapping
    public ResponseEntity save(@RequestBody Client client) throws Exception {
        service.save(client);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(client.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
