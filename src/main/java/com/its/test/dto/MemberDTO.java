package com.its.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
  private Long id;
  private String memberEmail;
  private String memberPassword;
  private String memberName;
}
