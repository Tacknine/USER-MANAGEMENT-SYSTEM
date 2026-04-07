package com.tacknine.ums.implement;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.entity.User;
import com.tacknine.ums.exception.ResourceNotFoundException;
import com.tacknine.ums.mapper.UserMapper;
import com.tacknine.ums.repository.UserRepository;
import com.tacknine.ums.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

     private final UserRepository repository;

     public UserServiceImpl(UserRepository repository) {
         this.repository = repository;
     }
// tafuta watu wote

     public  List<UserResponseDto> getAllUsers(){
         return repository.findAll()
                 .stream()
                 .map(UserMapper::toDto)
                 .toList();
     }

     // create umtumiaji
     public UserResponseDto createUser(UserRequestDto request){
         User user = new UserMapper()
                 .toEntity(request);
         User savedUser = repository.save(user);
         return UserMapper.toDto(savedUser);
     }


     @Override
     public UserResponseDto updateUser(Long id, UserRequestDto request) {
         // 1. Pata Entity kutoka repository kwanza (Hapa ndipo orElseThrow inakaa)
         User user = repository.findById(id).orElseThrow();
         // 2. Sasisha taarifa za entity
         user.setFirstName(request.getFirstName());
         user.setLastName(request.getLastName());
         user.setEmail(request.getEmail());
         user.setAge(request.getAge());
         user.setSalary(request.getSalary());
         user.setRole(request.getRole());
         user.setPassword(request.getPassword());

         // 3. Hifadhi na rudi kama DTO
         User savedUser = repository.save(user);
         return UserMapper.toDto(savedUser);
     }


    public UserResponseDto getUserById(Long id) {
        User user = repository.findById(id)
                // Correctly handle Optional: Throw exception if empty
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        return UserMapper.toDto(user);
    }




    @Override
    public boolean deleteUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        repository.delete(user);
        return false;
    }

<<<<<<< HEAD

    @Override
    public void DeleteUserById(Long id) {
=======
    @Override
    public UserResponseDto getUserByAge(Integer age) {
         User user = repository.findByAge(age).orElseThrow(()-> new ResourceNotFoundException(" use not found"));
         return UserMapper.toDto(user);
>>>>>>> 4bab57a ( adding of mapper, exceptinalhandeleling, and collection of delete function in service and service implimentation)

    }


<<<<<<< HEAD
    }}
=======
}
>>>>>>> 4bab57a ( adding of mapper, exceptinalhandeleling, and collection of delete function in service and service implimentation)
