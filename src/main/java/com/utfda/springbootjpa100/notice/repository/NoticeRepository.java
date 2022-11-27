package com.utfda.springbootjpa100.notice.repository;

import com.utfda.springbootjpa100.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {


    //ID 리스트에 있는 값들 중에 ID로 값을 찾아서 모은 다음에 List<Notice>로 반환
    Optional<List<Notice>> findByIdIn(List<Long> idList);

}

/*
* @Repository
* public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
* 원래
* */
