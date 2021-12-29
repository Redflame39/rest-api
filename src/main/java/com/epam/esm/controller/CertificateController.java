package com.epam.esm.controller;

import com.epam.esm.model.dto.CertificateDto;
import com.epam.esm.model.entity.Certificate;
import com.epam.esm.service.api.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService service;

    @Autowired
    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Certificate> read() {
        return service.findAll();
    }

    @PostMapping
    // TODO: replace return type void with another return type
    public void create(@RequestBody CertificateDto certificate) { // TODO: replace Certificate with CertificateDTO
        // TODO: implement
        service.create(certificate);
    }

    @PutMapping(value = "/{id}")
    public CertificateDto update(@PathVariable Long id, @RequestBody CertificateDto certificate) {
        // TODO: implement
        Certificate old = service.update(id, certificate);
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        // TODO: implement
    }
}
