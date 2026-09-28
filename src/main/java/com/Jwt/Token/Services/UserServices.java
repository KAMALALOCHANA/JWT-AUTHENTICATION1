package com.Jwt.Token.Services;

import com.Jwt.Token.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class UserServices {

    private List<User>store=new ArrayList<>();

    public UserServices()
    {
        store.add(new User(UUID.randomUUID().toString(),"KAMAL","KAMAL@GMAIL"));
        store.add(new User(UUID.randomUUID().toString(),"vimal","chandan@gmail"));
        store.add(new User(UUID.randomUUID().toString(),"sona","sona@gmail"));
        store.add(new User (UUID.randomUUID().toString(),"SUBHA","SUBHA@GMAIL.COM"));
    }
    public List<User> getUsers()
    {
        return this.store;
    }
}
