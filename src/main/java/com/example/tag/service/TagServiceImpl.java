package com.example.tag.service;

import com.example.tag.dto.request.TagAddRequestModel;
import com.example.tag.dto.request.TagDeleteRequestModel;
import com.example.tag.dto.request.TagUpdateRequestModel;
import com.example.tag.exception.TagException;
import com.example.tag.model.Tag;
import com.example.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final UserService userService;

    @Transactional
    @Override
    public void addTag(TagAddRequestModel tagAddRequestModel){
        userService.checkUser(tagAddRequestModel.getUsername());

        Tag tag = Tag.builder().tag(tagAddRequestModel.getTag()).username(tagAddRequestModel.getUsername()).build();

        tagRepository.save(tag);
    }

    @Transactional
    @Override
    public void updateTag(TagUpdateRequestModel tagUpdateRequestModel) {
        userService.checkUser(tagUpdateRequestModel.getUsername());

        List<Tag> tagList = tagRepository.findByIdAndUsername(tagUpdateRequestModel.getTagId(), tagUpdateRequestModel.getUsername());

        if(CollectionUtils.isEmpty(tagList)){
            throw new TagException("Tag not found");
        }

        boolean changed = false;

        for(Tag tags : tagList){
            if(tags.getTag() == null || (tags.getTag() != null && !tags.getTag().equals(tagUpdateRequestModel.getTag()))){
                tags.setTag(tagUpdateRequestModel.getTag());
                changed = true;
            }
        }

        if(changed){
            tagRepository.saveAll(tagList);
        }
    }

    @Transactional
    @Override
    public void deleteTag(TagDeleteRequestModel tagDeleteRequestModel) {
        userService.checkUser(tagDeleteRequestModel.getUsername());

        List<Tag> tagList = tagRepository.findByIdAndUsername(tagDeleteRequestModel.getTagId(), tagDeleteRequestModel.getUsername());

        if(CollectionUtils.isEmpty(tagList)){
            throw new TagException("Tag not found");
        }

        tagRepository.deleteAll(tagList);
    }

    @Override
    public List<Tag> getTags(){
        return tagRepository.findAll();
    }
}