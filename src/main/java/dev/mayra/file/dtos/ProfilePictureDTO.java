package dev.mayra.file.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePictureDTO {
  private Integer idProfilePicture;
  private String fileName;
  private String fileType;
  private byte[] data;
}
