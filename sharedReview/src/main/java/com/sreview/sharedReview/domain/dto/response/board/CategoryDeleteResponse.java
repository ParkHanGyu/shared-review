package com.sreview.sharedReview.domain.dto.response.board;

import com.sreview.sharedReview.domain.common.ResponseCode;
import com.sreview.sharedReview.domain.common.ResponseMessage;
import com.sreview.sharedReview.domain.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CategoryDeleteResponse extends ResponseDto {

    public CategoryDeleteResponse() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<CategoryDeleteResponse> success(){ // 성공
        return ResponseEntity.status(HttpStatus.OK).body(new CategoryDeleteResponse());
    }

    public static ResponseEntity<ResponseDto> fail(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(ResponseCode.CATEGORY_IN_USE, ResponseMessage.CATEGORY_IN_USE));
    }

}
