package com.example.tag.controller;

import com.example.tag.dto.request.TagAddRequestModel;
import com.example.tag.dto.request.TagDeleteRequestModel;
import com.example.tag.dto.request.TagUpdateRequestModel;
import com.example.tag.dto.response.BaseResponseModel;
import com.example.tag.model.Tag;
import com.example.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tag")
public class TagController {
    private final TagService tagService;

    @PostMapping(value = "/add")
    public ResponseEntity<BaseResponseModel> add(@RequestBody TagAddRequestModel tagAddRequestModel) {
        tagService.addTag(tagAddRequestModel);
        return ResponseEntity.ok(BaseResponseModel.builder().success(true).build());
    }

    @PostMapping(value = "/update")
    public ResponseEntity<BaseResponseModel> update(@RequestBody TagUpdateRequestModel tagUpdateRequestModel) {
        tagService.updateTag(tagUpdateRequestModel);
        return ResponseEntity.ok(BaseResponseModel.builder().success(true).build());
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResponseModel> delete(@RequestBody TagDeleteRequestModel tagDeleteRequestModel) {
        tagService.deleteTag(tagDeleteRequestModel);
        return ResponseEntity.ok(BaseResponseModel.builder().success(true).build());
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Tag>> getTags() {
        List<Tag> tagList = tagService.getTags();
        return ResponseEntity.ok(tagList);
    }
}
