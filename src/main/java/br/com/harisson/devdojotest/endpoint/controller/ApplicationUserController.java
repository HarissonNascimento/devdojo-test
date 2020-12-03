package br.com.harisson.devdojotest.endpoint.controller;

import br.com.harisson.devdojotest.endpoint.service.ApplicationUserService;
import br.com.harisson.devdojotest.model.ApplicationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    @GetMapping(path = "/listAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplicationUser>> listAllAplicationUsers(){
        return ResponseEntity.ok(applicationUserService.listAllApplicationUsers());
    }
}
