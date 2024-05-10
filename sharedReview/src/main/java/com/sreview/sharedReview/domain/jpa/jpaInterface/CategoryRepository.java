package com.sreview.sharedReview.domain.jpa.jpaInterface;

import com.sreview.sharedReview.domain.jpa.entity.Board;
import com.sreview.sharedReview.domain.jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> { // 영속성 컨텍스트에 넣어주는 친구

    Optional<Category> findByName(String name);



    // 사용자 이름
    @Query("SELECT c FROM Category c WHERE c.user.nickname = :nickname") // 수정된 부분: "USER_ID" 대신 "user" 속성 사용
    List<Category> findByUserNickname(@Param("nickname") String nickname);

    // 카테고리 내용
//    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
//    List<Category> findByCategoryName(@Param("categoryName") String categoryName);


//    @Query("SELECT c FROM Category c WHERE c.USER_ID = ?1")
//    List<Category> findByCategoryName(String inputValue);

//    @Query("SELECT c FROM Category c WHERE c.CREATE_DATE = ?1")
//    List<Category> findByCreateDate(String inputValue);




//    @Query("SELECT c FROM Category c WHERE CASE WHEN :searchCriteria = 'id' THEN c.id = :inputValue " +
//            "WHEN :searchCriteria = 'categoryName' THEN c.categoryName = :inputValue ELSE TRUE END")
//    List<Category> findBySearchCriteria(@Param("searchCriteria") String searchCriteria, @Param("inputValue") String inputValue);
}
