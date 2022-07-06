package com.its.test.entity;

import com.its.test.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "board_test_table")
public class BoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_id")
  private Long id;

  @Column(name = "board_writer", length = 30, nullable = false)
  private String boardWriter;

  @Column(name = "board_title", length = 50, nullable = false)
  private String boardTitle;

  @Column(name = "board_contents", length = 500)
  private String boardContents;

  @Column(name = "board_hits")
  private int boardHits;

  @Column(name = "board_created_time")
  private LocalDateTime boardCreatedTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private MemberEntity memberEntity;

  public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setBoardWriter(boardDTO.getBoardWriter());
    boardEntity.setBoardTitle(boardDTO.getBoardTitle());
    boardEntity.setBoardContents(boardDTO.getBoardContents());
    boardEntity.setBoardHits(boardDTO.getBoardHits());
    boardEntity.setBoardCreatedTime(boardDTO.getBoardCreatedTime());
    return boardEntity;
  }
}
