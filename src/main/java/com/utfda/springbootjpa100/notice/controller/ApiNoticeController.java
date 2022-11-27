package com.utfda.springbootjpa100.notice.controller;


import com.utfda.springbootjpa100.notice.entity.Notice;
import com.utfda.springbootjpa100.notice.exception.AlreadyDeletedException;
import com.utfda.springbootjpa100.notice.exception.DuplicateNoticeExcetpion;
import com.utfda.springbootjpa100.notice.exception.NoticeNotFundException;
import com.utfda.springbootjpa100.notice.model.NoticeDeleteInput;
import com.utfda.springbootjpa100.notice.model.NoticeInput;
import com.utfda.springbootjpa100.notice.model.ResponseError;
import com.utfda.springbootjpa100.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ApiNoticeController {

    private final NoticeRepository noticeRepository;

//    @GetMapping("/api/notice")
//    public String noticeSTring(){
//
//        return "공지사항입니다.";
//    }

//    @GetMapping("/api/notice")
//    public NoticeInput notice(){
//
//        LocalDateTime regdt = LocalDateTime.of(2021,2,8,0,0);
//
//        NoticeInput notice = new NoticeInput();
//        notice.setId(1);
//        notice.setTitle("공지사항입니다.");
//        notice.setContents("공지사항 내용입니다.");
//        notice.setRegDt(regdt);
//
//        return notice;
//
//    }

//    @GetMapping("/api/notice")
//    public List<NoticeInput> notice(){
//        List<NoticeInput> list = new ArrayList<>();
//
//        list.add(NoticeInput.builder().id(1).title("첫 번째 공지사항").contents("첫 번째 공지사항입니다.").regDt(LocalDateTime.of(2021, 1, 30, 0,0 )).
//                build());
//
//        list.add(NoticeInput.builder().id(2).title("두 번째 공지사항").contents("두 번째 공지사항입니다.").regDt(LocalDateTime.of(2021, 12, 31, 0,0 )).
//                build());
//
//        return list;
//    }


//    @GetMapping("/api/notice")
//    public List<NoticeInput> notice() {
//        List<NoticeInput> notice = new ArrayList<>();
//
//        return notice;
//    }
//
//    @GetMapping("/api/notice/count")
//    public String noticeCount() {
//        return "20";
//    }
//
//    @PostMapping("/api/notice")
//    public NoticeInput addNotice(String title, String contents) {
//
//
//        NoticeInput notice = NoticeInput.builder()
//                .id(1L)
//                .title(title)
//                .contents(contents)
//                .regDt(LocalDateTime.now())
//                .build();
//
//        return notice;
//    }
//
//    @PostMapping("/api/notice")
//    public NoticeInput addNotice(NoticeInput noticeModel){
//
//        noticeModel.setId(2);
//        noticeModel.setRegDt(LocalDateTime.now());
//
//        return noticeModel;
//    }

//    @PostMapping("/api/notice")
//    public Notice addNotice(@RequestBody NoticeInput noticeInput) {
//
//        Notice notice = Notice.builder().
//                title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .regDate(LocalDateTime.now())
//                .build();
//
//
//        noticeRepository.save(notice);
//
//        return notice;
//    }
//
//    @PostMapping("/api/notice")
//    public Notice addNotice(@RequestBody NoticeInput noticeInput) {
//
//        Notice notice = Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .regDate(LocalDateTime.now())
//                .hits(0)
//                .likes(0)
//                .build();
//
//        Notice resultNotice = noticeRepository.save(notice);
//
//        return resultNotice;
//    }

    @GetMapping("/api/notice/{id}")
    public Notice notice(@PathVariable Long id) {
        Optional<Notice> notice = noticeRepository.findById(id);

        if (notice.isPresent()) {
            return notice.get();
        }
        return null;
    }

    @PutMapping("/api/notice/{id}")
    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {

        Optional<Notice> notice = noticeRepository.findById(id);

        if (notice.isPresent()) {
            notice.get().setTitle(noticeInput.getTitle());
            notice.get().setTitle(noticeInput.getTitle());
            notice.get().setContents(noticeInput.getContents());
            notice.get().setUpdateDate(LocalDateTime.now());

            noticeRepository.save(notice.get());
        }
    }


    //커스텀으로 예외에 대한 코드 던져주기
    @ExceptionHandler(NoticeNotFundException.class)
    public ResponseEntity<String> handlerNoticeNotFundExcetpion(NoticeNotFundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @PutMapping("/api/notice/{id}")
//    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {
//

    // 첫 번째 방법
//        Optional<Notice> notice = noticeRepository.findById(id);
//
//        //예외 발생
//        if(!notice.isPresent()){
//            throw new NoticeNotFundException("공지사항에 글이 존재하지 않습니다.");
//        }
//
//        notice.get().setTitle(noticeInput.getTitle());
//        notice.get().setContents(noticeInput.getContents());
//        notice.get().setUpdateDate(LocalDateTime.now());
//        noticeRepository.save(notice.get());


//
//        // 두 번째 방법
//        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new NoticeNotFundException("공지사항의 글이 존재하지 않습니다."));
//
//        notice.setTitle(noticeInput.getTitle());
//        notice.setContents(noticeInput.getContents());
//        notice.setUpdateDate(LocalDateTime.now());
//
//        noticeRepository.save(notice);
//
//        //게시글이 있을 때

//    }

//
//    @PutMapping("/api/notice/{id}")
//    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput){
//        Notice notice = noticeRepository.findById(id)
//                .orElseThrow(() -> new NoticeNotFundException("공지사항의 글이 존재하지 않습니다."));
//
//        notice.setTitle(noticeInput.getTitle());
//        notice.setContents(noticeInput.getContents());
//        notice.setUpdateDate(LocalDateTime.now());
//
//        noticeRepository.save(notice);
//    }

    @PatchMapping("/api/notice/{id}")
    public void noticeHits(@PathVariable Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFundException("공지사항의 글이 존재하지 않습니다."));

        notice.setHits(notice.getHits() + 1);
        noticeRepository.save(notice);
    }
//
//    @DeleteMapping("/api/notice/{id}")
//    public void deleteNotice(@PathVariable Long id){
//        Optional<Notice> notice = noticeRepository.findById(id);
//        if(notice.isPresent()){
//            noticeRepository.delete(notice.get());
//        }
//
//    }

//    @DeleteMapping("/api/notice/{id}")
//    public void deleteNotice(@PathVariable Long id){
//        Notice notice = noticeRepository.findById(id)
//                .orElseThrow(() -> new NoticeNotFundException("공지사항의 글이 존재하지 않습니다."));
//
//        noticeRepository.delete(notice);
//    }

    @ExceptionHandler(AlreadyDeletedException.class)
    public ResponseEntity<String> handlerAlreadyDeletedException(AlreadyDeletedException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }


    @DeleteMapping("/api/notice/{id}")
    public void deleteNotice(@PathVariable Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new NoticeNotFundException("공지사항이 없습니다."));

        if (notice.isDeleted()) {
            throw new AlreadyDeletedException("이미 삭제된 글입니다.");
        }

        notice.setDeleted(true);
        notice.setDeletedDate(LocalDateTime.now());

        noticeRepository.save(notice);
    }


    @DeleteMapping("/api/notice")
    public void deleteNoticeList(@RequestBody NoticeDeleteInput noticeDeleteInput) {

        List<Notice> noticeList = noticeRepository.findByIdIn(noticeDeleteInput.getIdList())
                .orElseThrow(() -> new NoticeNotFundException("공지사항에 글이 존재하지 않습니다"));

        noticeList.stream().forEach(e -> {
            e.setDeleted(true);
            e.setDeletedDate(LocalDateTime.now());
        });

        noticeRepository.saveAll(noticeList);
    }

    @DeleteMapping("/api/notice/all")
    public void deleteAll() {
        noticeRepository.deleteAll();
    }

//    @PostMapping("/api/notice")
//    public void addNotice(@RequestBody NoticeInput noticeInput){
//
//        Notice notice = Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .hits(0)
//                .likes(0)
//                .regDate(LocalDateTime.now())
//                .build();
//
//        noticeRepository.save(notice);
//
//    }


//    @PostMapping("/api/notice")
//    public ResponseEntity<Object> addNotice(@RequestBody @Valid NoticeInput noticeInput, Errors errors){
//
//        if(errors.hasErrors()){
////            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
//            List<ResponseError> responseErrors = new ArrayList<>();
//
//            errors.getAllErrors().stream().forEach(e -> {
//                responseErrors.add(ResponseError.of((FieldError)e));
//            });
//
//            return new ResponseEntity<>(responseErrors, HttpStatus.BAD_REQUEST);
//        }
//
//        noticeRepository.save(Notice.builder()
//                        .title(noticeInput.getTitle())
//                        .contents(noticeInput.getContents())
//                        .hits(0)
//                        .likes(0)
//                        .regDate(LocalDateTime.now())
//                        .build());
//
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/api/notice")
    public ResponseEntity<Object> addNotice(@RequestBody @Valid NoticeInput noticeInput, Errors errors) {

        //@Valid를 하면서 에러가 발생하면 에러가 담긴다.
        if (errors.hasErrors()) {
            List<ResponseError> responseErrors = new ArrayList<>();
            errors.getAllErrors().stream().forEach(e -> {
                responseErrors.add(ResponseError.of((FieldError) e)); //에러를 필드 에러로 형변환 먼저 해야 함
            });

            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        noticeRepository.save(Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .hits(0)
                .likes(0)
                .regDate(LocalDateTime.now())
                .build());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/notice/latest/{size}")
    public Page<Notice> noticeLatest(@PathVariable int size) {
        Page<Notice> pages =
                noticeRepository.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "regDate"));
        return pages;
    }

    @ExceptionHandler(DuplicateNoticeExcetpion.class)
    public ResponseEntity<?> handlerDuplicatedNoticeException(DuplicateNoticeExcetpion excetpion) {
        return new ResponseEntity<>(excetpion.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @PostMapping("/api/notice")
//    public ResponseEntity<Object> addNotice(@RequestBody @Valid NoticeInput noticeInput, Errors errors){
//
//
//        //중복 체크
//
//        LocalDateTime checkDate = LocalDateTime.now().minusMinutes(1);
//
//        int noticeCount = noticeRepository.countByTitleAndContentsAndRegDateIsGreaterThanEqual(
//                noticeInput.getTitle(), noticeInput.getContents(), checkDate);
//            if(noticeCount > 0){
//                throw new DuplicateNoticeExcetpion("1분 이내에 등록된 동일한 공지사항이 존재합니다.");
//            }
//
//
//
//        noticeRepository.save(Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .hits(0)
//                .likes(0)
//                .regDate(LocalDateTime.now())
//                .build());
//
//        return ResponseEntity.ok().build();
//    }


}
