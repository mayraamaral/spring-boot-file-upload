package dev.mayra.file.entities;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Types;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "profile_picture")
public class ProfilePicture {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_picture_seq")
  @SequenceGenerator(name = "profile_picture_seq", sequenceName = "profile_picture_seq", allocationSize = 1)
  @Column(name = "id_profile_picture")
  private Integer idProfilePicture;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "file_type")
  private String fileType;

  @Column(name = "data")
  @Lob
  @JdbcTypeCode(Types.BINARY)
  private byte[] data;

  @JsonIgnore
  @OneToOne(mappedBy = "profilePicture", fetch = FetchType.LAZY)
  private User user;
}
