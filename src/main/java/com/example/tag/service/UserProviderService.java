package com.example.tag.service;

import com.example.tag.model.UserProvider;

public interface UserProviderService {
    UserProvider getByGoogleSubId(String googleSubId);

    void save(UserProvider userProvider);
}
