package com.example.atbashdecryptor.controller;

import com.example.atbashdecryptor.service.SimpleDecryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AtbashController {

    @Autowired
    private SimpleDecryptor simpleDecryptor;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/decrypt")
    @ResponseBody
    public String decrypt(@RequestBody String encryptedText) {
        return simpleDecryptor.decrypt(encryptedText);
    }
}