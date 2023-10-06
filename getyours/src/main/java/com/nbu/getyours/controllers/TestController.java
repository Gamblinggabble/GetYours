package com.nbu.getyours.controllers;

import com.nbu.getyours.scripts.PythonScriptRunner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("get")
public class TestController {

    private PythonScriptRunner runner = new PythonScriptRunner();

    @GetMapping
    public String getAboutPrice() {
        return runner.executeScriptGetPrice("https://www.aboutyou.bg/p/karolina-kurkova-originals/chehli-giovanna-8949607");
    }

}
