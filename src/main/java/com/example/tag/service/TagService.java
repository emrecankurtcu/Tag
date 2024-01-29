package com.example.tag.service;

import com.example.tag.dto.request.TagAddRequestModel;
import com.example.tag.dto.request.TagDeleteRequestModel;
import com.example.tag.dto.request.TagUpdateRequestModel;
import com.example.tag.model.Tag;

import java.util.List;

public interface TagService {

    void addTag(TagAddRequestModel tagAddRequestModel);

    void updateTag(TagUpdateRequestModel tagUpdateRequestModel);

    void deleteTag(TagDeleteRequestModel tagDeleteRequestModel);

    List<Tag> getTags();


}
