package com.pard.user.repository;

import com.pard.user.dto.UserDto;
import com.pard.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private static final Map<Long, User> handong = new HashMap<>();

    public void save(UserDto userDto) {
        User user = User.builder()
                .studentID(userDto.getStudentID())
                .studentName(userDto.getStudentName())
                .build();
        handong.put(userDto.getStudentID(), user);

    }

    public UserDto findByID(Long studentID) {
        User user = handong.get(studentID);

        return UserDto.builder()
                .studentID(user.getStudentID())
                .studentName(user.getStudentName())
                .build();
    }

    public void updateByID(Long studentID, UserDto userDto) {
        User user = handong.get(studentID);

        user.setStudentName(userDto.getStudentName());
        user.setStudentID(userDto.getStudentID());
    }


    public void delete(Long studentID) {
        handong.remove(studentID);
    }

    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user -> UserDto.builder()
                .studentID(user.getStudentID())
                .studentName(user.getStudentName())
                .build()).toList();
    }
}
