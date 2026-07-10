package in.demo.SQLInjection.service;

import in.demo.SQLInjection.dao.UserDAO;
import in.demo.SQLInjection.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO dao;

    public String register(User user) {

        if (dao.register(user))
            return "Registration Successful";

        return "Registration Failed";
    }

    public String loginStatement(User user) {

        if (dao.loginUsingStatement(user))
            return "Welcome " + user.getUsername();

        return "Invalid Credentials";
    }

    public String loginPrepared(User user) {

        if (dao.loginUsingPrepared(user))
            return "Welcome " + user.getUsername();

        return "Invalid Credentials";
    }

}
