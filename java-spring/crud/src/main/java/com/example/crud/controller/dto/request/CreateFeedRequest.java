package com.example.crud.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotBlank(message = "tilte은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 20, message = "title은 1~20자 사이여야 합니다.")
    private String title;

    @NotBlank(message = "content는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 1000, message = "content는 1~1000자 사이여야 합니다.")
    private String content;
}
