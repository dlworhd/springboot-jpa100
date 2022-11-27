package com.utfda.springbootjpa100.notice.exception;

public class DuplicateNoticeExcetpion extends RuntimeException {
    public DuplicateNoticeExcetpion(String message) {
        super(message);
    }
}
