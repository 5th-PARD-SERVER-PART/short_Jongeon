package com.pard.user.service;

import com.pard.user.dto.UserDto;
import com.pard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;

        public void saveUser(UserDto userDto) {
            userRepository.save(userDto);
        }

        public UserDto findByID(Long studentID) {
            return userRepository.findByID(studentID);
        }


        public void updateByID(Long studentID, UserDto userDto) {
                userRepository.updateByID(studentID, userDto);
        }

        public void delete(Long studentID) {
                userRepository.delete(studentID);
        }

        public List<UserDto> findAll() {
            return userRepository.findAll();
        }
}
