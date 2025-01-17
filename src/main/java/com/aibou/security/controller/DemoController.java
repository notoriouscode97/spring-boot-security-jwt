package com.aibou.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}

// Done - Useru da dodam da bude:
// Done - User (id, firstName, lastName, username, email, createdBy, createdAt, modifiedBy, modifiedAt)
// Done - Kada se kreira korisnik da validiramo polja za unos novih korisnika
// Done - minimalna duzina username, regex za email
// Done - Admin moze da kreira korisnike (proveri da li radi)
// Done - Da razdvojim layere, da imamo controllere, repository, domain i service
// Done - da imam na umu auditing kod entiteta
// Done - da bacim pogled na https://medium.com/thefreshwrites/jpa-auditing-spring-boot-spring-security-575c77867570
// Done - Admin moze da vidi listu svih korisnika (UserResponse: id, username, role, createdBy, createdAt, modifiedBy, modifiedAt)
// Za User tabelu da dodam liquibase

// Dodavanje Swaggera
// Pisanje Junit testova za usere

// Logovanje: https://www.geeksforgeeks.org/spring-boot-logging/. Za sada mozes najjednostavniji nacin da dodas preko lomboka
// Endpoint za dodavanje novih korisnika sa invite email-om (email sending + thymeleaf)