package com.example.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://two024-2-t03-petshopguara-tlv0.onrender.com", "http://127.0.0.1:5501"})
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "Backend funcionando! 🚀";
    }
}

