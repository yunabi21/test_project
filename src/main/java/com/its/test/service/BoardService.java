package com.its.test.service;

import com.its.test.dto.BoardDTO;
import com.its.test.entity.BoardEntity;
import com.its.test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public Long save(BoardDTO boardDTO) {
    BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
    Long saveId = boardRepository.save(boardEntity).getId();
    return saveId;
  }

  public List<BoardDTO> findAll() {
    List<BoardEntity> boardEntityList = boardRepository.findAll();
    List<BoardDTO> boardDTOList = new ArrayList<>();
    for (BoardEntity boardEntity : boardEntityList) {
      boardDTOList.add(BoardDTO.toDTO(boardEntity));
    }
    return boardDTOList;
  }

  public BoardDTO findById(Long id) {
    Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
    if (optionalBoardEntity.isPresent()) {
      BoardEntity boardEntity = optionalBoardEntity.get();
      BoardDTO boardDTO = BoardDTO.toDTO(boardEntity);
      return boardDTO;
    } else {
      return null;
    }
  }
}
