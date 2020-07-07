package com.sucaisheng.Mapper;

import com.sucaisheng.pojo.User;
import com.sucaisheng.vo.*;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {
    List<User> getAllUser();

    void deleteUserById(int id);

    void insert(User user);

    List<User> getUsersByUsername(QueryVo queryVo);

    List<User> getUserBySexAndUsername(User user);

    List<User> getUserByListId(ArrayList<Integer> ids);
}
