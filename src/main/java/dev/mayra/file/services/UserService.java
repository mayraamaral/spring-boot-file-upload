package dev.mayra.file.services;

import dev.mayra.file.dtos.ProfilePictureDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import dev.mayra.file.dtos.UserResponseDTO;
import dev.mayra.file.dtos.UserDTO;
import dev.mayra.file.entities.ProfilePicture;
import dev.mayra.file.entities.User;
import dev.mayra.file.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final ObjectMapper objectMapper;

  public UserResponseDTO createUser(UserDTO userDTO, MultipartFile profilePicture) throws IOException {

    User user = objectMapper.convertValue(userDTO, User.class);
    ProfilePicture picture = new ProfilePicture();
    picture.setFileName(randomUUID().toString());
    picture.setFileType(profilePicture.getContentType());
    picture.setData(profilePicture.getBytes());

    user.setProfilePicture(picture);

    userRepository.save(user);

    return objectMapper.convertValue(user, UserResponseDTO.class);
  }

  public List<UserResponseDTO> listUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(user -> {
      ProfilePictureDTO profilePictureDTO = objectMapper.convertValue(user.getProfilePicture(), ProfilePictureDTO.class);
      UserResponseDTO userDTO = objectMapper.convertValue(user, UserResponseDTO.class);
      userDTO.setProfilePicture(profilePictureDTO);
      return userDTO;
    }).toList();
  }
}
