package com.example.demo.domain.wiseSaying.controller;

import com.example.demo.domain.wiseSaying.entitiy.WiseSaying;
import com.example.demo.domain.wiseSaying.service.WiseSayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //  GET  /wiseSayings  -> 명언들을 가져와라
    //  GET  /wiseSayings/1 -> 명언들 중에서 1번 가져와라

    @GetMapping("/wiseSayings/{id}")
    public WiseSaying getItem1(@PathVariable int id) {
        //@PathVariable("id") int id 는 /wiseSayings/{id} 에서 {id}에 해당하는 값을 int id에 넣어준다.
        // 변수가 같으면 () 는 생략 가능하다.
        return wiseSayingService.getItem(id).orElse(null);
    }

    @GetMapping("/wiseSayings/{id}/delete")
    // @DeleteMapping("/wiseSayings/{id}") // 이렇게 써도 된다. 그러나 아직..
    public boolean deleteItem(@PathVariable int id) {
        return wiseSayingService.deleteById(id);
    }
}
