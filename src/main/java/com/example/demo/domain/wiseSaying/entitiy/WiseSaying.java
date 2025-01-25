package com.example.demo.domain.wiseSaying.entitiy;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WiseSaying {
    private int id;
    private String content;
    private String author;
}
