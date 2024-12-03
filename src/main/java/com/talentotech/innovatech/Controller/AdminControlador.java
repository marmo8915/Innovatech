package com.talentotech.innovatech.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private AdminControlador adminControlador;

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin adminGuardar = adminServicio.guardarAdmin(admin);
        return new ResponseEntity<>(adminGuardar, HttpStatus.CREATED);
    }
}
