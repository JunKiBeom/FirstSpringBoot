package com.example.demo.domain.wiseSaying.controller;

import com.example.demo.domain.wiseSaying.entitiy.WiseSaying;
import com.example.demo.domain.wiseSaying.service.WiseSayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WiseSayingController {

    private final WiseSayingService wiseSayingService;

    @Autowired
    public WiseSayingController(WiseSayingService wiseSayingService) {
        this.wiseSayingService = wiseSayingService;
    }

    @GetMapping("/wiseSayings")
    public List<WiseSaying> getWiseSayings() {
        return wiseSayingService.getAllItems();
    }

    @GetMapping("/wiseSaying/write")
    public WiseSaying writeWiseSaying(String content, String author) {
        //@RequstParam 어노테이션을 붙이지 않아도 스프링부트가 자동으로 매핑해준다.

        return wiseSayingService.write(content, author);
    }
}
