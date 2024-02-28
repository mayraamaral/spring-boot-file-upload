package dev.mayra.file.dtos;

import dev.mayra.file.entities.ProfilePicture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
  private Integer idUser;

  private String name;

  private String email;

  private ProfilePictureDTO profilePicture;
}
