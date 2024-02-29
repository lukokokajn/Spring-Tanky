package com.example.springtanky.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @GetMapping("/maps")
    public String renderIndex() {
        return "pages/home/maps";
    }
}