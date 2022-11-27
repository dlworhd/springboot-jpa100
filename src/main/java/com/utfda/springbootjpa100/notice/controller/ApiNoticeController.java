package com.utfda.springbootjpa100.notice.controller;


import com.utfda.springbootjpa100.notice.entity.Notice;
import com.utfda.springbootjpa100.notice.exception.AlreadyDeletedException;
import com.utfda.springbootjpa100.notice.exception.NoticeNotFundException;
import com.utfda.springbootjpa100.notice.model.NoticeDeleteInput;
import com.utfda.springbootjpa100.notice.model.NoticeInput;
import com.utfda.springbootjpa100.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/notice/count")
    public String noticeCount() {
        return "20";
    }

//    @PostMapping("/api/notice")
//    public NoticeInput addNotice(@RequestParam String title, @RequestParam String contents) {
//
//
//        NoticeInput notice = NoticeInput.builder()
//                .id(1)
//                .title(title)
//                .contents(contents)
//                .regDt(LocalDateTime.now())
//                .build();
//
//        return notice;
//    }

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

//     @PutMapping("/api/notice/{id}")
//    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput){
//
//        Optional<Notice> notice = noticeRepository.findById(id);
//
//        if(notice.isPresent()){
//            notice.get().setTitle(noticeInput.getTitle());
//            notice.get().setTitle(noticeInput.getTitle());
//            notice.get().setContents(noticeInput.getContents());
//            notice.get().setUpdateDate(LocalDateTime.now());
//
//            noticeRepository.save(notice.get());
//        }
//     }


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


    @PutMapping("/api/notice/{id}")
    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput){
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFundException("공지사항의 글이 존재하지 않습니다."));

        notice.setTitle(noticeInput.getTitle());
        notice.setContents(noticeInput.getContents());
        notice.setUpdateDate(LocalDateTime.now());

        noticeRepository.save(notice);
    }

    @PatchMapping("/api/notice/{id}")
    public void noticeHits(@PathVariable Long id){
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
    public void deleteNotice(@PathVariable Long id){
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new NoticeNotFundException("공지사항이 없습니다."));

        if(notice.isDeleted()){
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
    public void deleteAll(){
        noticeRepository.deleteAll();
    }

    @PostMapping("/api/notice")
    public void addNotice(@RequestBody NoticeInput noticeInput){

        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .hits(0)
                .likes(0)
                .regDate(LocalDateTime.now())
                .build();

        noticeRepository.save(notice);

    }


}
