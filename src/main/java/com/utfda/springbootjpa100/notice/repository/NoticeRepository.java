package com.utfda.springbootjpa100.notice.repository;

import com.utfda.springbootjpa100.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {


    //ID 리스트에 있는 값들 중에 ID로 값을 찾아서 모은 다음에 List<Notice>로 반환
    Optional<List<Notice>> findByIdIn(List<Long> idList);
    //제목 동일, 내용 동일, 등록시간이 체크시간보다 크다.
    Optional<List<Notice>> findByTitleAndContentsAndRegDateIsGreaterThanEqual(String title, String contents, LocalDateTime regDate);

    //타이틀, 컨텐츠, 같거나 더 큰 Date를 찾는다.
    int countByTitleAndContentsAndRegDateIsGreaterThanEqual(String title, String contents, LocalDateTime regDate);
}

/*
* @Repository
* public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
* 원래
* */
