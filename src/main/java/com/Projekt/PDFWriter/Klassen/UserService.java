package main.java.com.Projekt.PDFWriter.Klassen;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserInfoRepository userInfoRepository;

    public UserService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public List<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo createUser(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

}