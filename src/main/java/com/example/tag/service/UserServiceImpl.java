package com.example.tag.service;

import com.example.tag.exception.OAuth2Exception;
import com.example.tag.exception.UserException;
import com.example.tag.model.User;
import com.example.tag.model.UserProvider;
import com.example.tag.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserProviderService userProviderService;
    private final PasswordEncoder passwordEncoder;
    private final String USERNAME_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    private final int USERNAME_LENGTH = 18;
    private final int PASSWORD_LENGTH = 18;

    @Override
    public void checkUser(String username) {
        User user = userRepository.findByUsername(username);

        if(user == null || !user.isActiveUser() || user.isBanned()){
            throw new UserException("User not found");
        }
    }

    @Override
    @Transactional
    public void googleLogin(OAuth2User oAuth2User) {
        String googleSubId = oAuth2User.getAttribute("sub");

        if(googleSubId == null || googleSubId.isEmpty()){
            throw new OAuth2Exception("Sub ID not found");
        }

        UserProvider userProvider = userProviderService.getByGoogleSubId(googleSubId);

        if(userProvider != null){
            return;
        }

        User willBeRegistered = this.getUserFromOAuth2User(oAuth2User);

        User registeredUser = userRepository.findByEmail(willBeRegistered.getEmail());

        int userId;
        if(registeredUser == null){
            User savedUser = userRepository.save(willBeRegistered);
            userId = savedUser.getId();
        }
        else{
            userId = registeredUser.getId();
        }

        this.createUserProvider(userId, googleSubId, "GOOGLE");
    }

    private User getUserFromOAuth2User(OAuth2User oAuth2User){
        String firstname = oAuth2User.getAttribute("given_name");
        String lastname = oAuth2User.getAttribute("family_name");
        String email = oAuth2User.getAttribute("email");
        boolean isEmailVerified = oAuth2User.getAttribute("email_verified");

        User user = new User();
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(this.generateString(USERNAME_LENGTH));
        user.setEmailVerified(isEmailVerified);
        user.setActiveUser(true);
        user.setPassword(passwordEncoder.encode(this.generateString(PASSWORD_LENGTH)));

        return user;
    }

    private void createUserProvider(int userId, String googleSubId, String provider){
        UserProvider userProvider = new UserProvider();
        userProvider.setUserId(userId);
        userProvider.setGoogleSubId(googleSubId);
        userProvider.setProvider(provider);

        userProviderService.save(userProvider);
    }

    private String generateString(int length) {
        StringBuilder string = new StringBuilder();
        Random rnd = new Random();
        while (string.length() < length) {
            int index = (int) (rnd.nextFloat() * USERNAME_CHARS.length());
            string.append(USERNAME_CHARS.charAt(index));
        }
        return string.toString();
    }
}
