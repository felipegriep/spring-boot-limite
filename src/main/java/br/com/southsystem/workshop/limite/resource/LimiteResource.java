package br.com.southsystem.workshop.limite.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limite")
public class LimiteResource {

    @GetMapping
    public ResponseEntity<String> get() {

        return ResponseEntity.ok("Teste");
    }
}
