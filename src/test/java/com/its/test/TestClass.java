package com.its.test;

import com.its.test.dto.BoardDTO;
import com.its.test.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestClass {
  @Autowired
  private BoardService boardService;

  @Test
  @Transactional
  @Rollback
  public void saveTest() {
    String testTitle = "testTitle";
    String testWriter = "testWriter";
    String testContents = "testContents";

    Long saveId = boardService.save(new BoardDTO(testWriter, testTitle, testContents));
    String boardWriter = boardService.findById(saveId).getBoardWriter();
    assertThat(testWriter).isEqualTo(boardWriter);
  }
}
