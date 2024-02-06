package com.example.tag.service;

import com.example.tag.model.UserProvider;
import com.example.tag.repository.UserProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserProviderServiceImpl implements UserProviderService {
    private final UserProviderRepository userProviderRepository;


    @Override
    public UserProvider getByGoogleSubId(String googleSubId) {
        return userProviderRepository.findByGoogleSubId(googleSubId);
    }

    @Override
    @Transactional
    public void save(UserProvider userProvider) {
        userProviderRepository.save(userProvider);
    }
}
