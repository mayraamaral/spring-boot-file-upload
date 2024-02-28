package dev.mayra.file.controllers;

import dev.mayra.file.dtos.UserDTO;
import dev.mayra.file.dtos.UserResponseDTO;
import dev.mayra.file.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<UserResponseDTO> createUser(@RequestPart String name, @RequestPart String email, @RequestPart MultipartFile profilePicture) throws IOException {
    UserDTO userDTO = new UserDTO();
    userDTO.setName(name);
    userDTO.setEmail(email);
    return ResponseEntity.ok(userService.createUser(userDTO, profilePicture));
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> listUsers() {
    return ResponseEntity.ok(userService.listUsers());
  }

}
