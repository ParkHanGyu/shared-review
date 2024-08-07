package com.sreview.sharedReview.domain.jpa.service;

import com.sreview.sharedReview.domain.jpa.entity.Board;
import com.sreview.sharedReview.domain.jpa.entity.Favorite;
import com.sreview.sharedReview.domain.jpa.jpaInterface.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FavoriteRepoService {
    private final FavoriteRepository favoriteRepository;

    @Transactional
    public void save(Favorite favorite) {
        // FAVORITE 테이블에 컬럼 생성
        favoriteRepository.save(favorite);

        // 게시물 좋아요 카운터 증가
        favoriteRepository.incrementFavoriteCount(favorite.getBoard().getBoardId());
    }

    @Transactional
    public int delete(Long boardId, String email) {
        int deletedCount = favoriteRepository.deleteFavoriteByBoardIdEmail(boardId, email);
        // deletedCount는 삭제된 컬럼 수
        // deletedCount가 0보다 크다는거는 정상적으로 삭제됨. => 게시물 좋아요 감소
        if (deletedCount > 0) {
            favoriteRepository.decrementFavoriteCount(boardId);
        }
        return deletedCount;
    }

    public List<Favorite> findAllByBoard(Board board) {
        return favoriteRepository.findAllByBoard(board);
    }

    public Integer countByBoardId(Long boardId) {
        return favoriteRepository.countByBoardId(boardId);
    }


}