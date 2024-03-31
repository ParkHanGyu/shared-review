package com.sreview.sharedReview.domain.dto.response.user;

import com.sreview.sharedReview.domain.common.ResponseCode;
import com.sreview.sharedReview.domain.common.ResponseMessage;
import com.sreview.sharedReview.domain.dto.object.UserDto;
import com.sreview.sharedReview.domain.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetLoginUserResponse extends ResponseDto {

    private UserDto userDto;
    public GetLoginUserResponse(UserDto userDto) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userDto = userDto;

    }
    public static ResponseEntity<GetLoginUserResponse> success(UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(new GetLoginUserResponse(userDto));
    }
    public static ResponseEntity<ResponseDto> noExistedUser(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(ResponseCode.NON_EXISTED_USER, ResponseMessage.NON_EXISTED_USER));
    }
}
