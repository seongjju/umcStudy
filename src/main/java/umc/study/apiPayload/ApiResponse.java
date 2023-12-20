package umc.study.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"}) //객체를 JSON으로 직렬화할 때 속성의 순서를 지정하는데 사용
public class ApiResponse<T> {

    //isSuccess: 성공인지 아닌지 알려주는 필드
    //code : HTTP 상태코드로는 너무 제한적인 정보만 줄 수 있어서 조금 더 세부적인 응답 상황을 알려주기 위한 필드, API응답에 자체적인 우리만의 code,message 도입
    //message : code에 추가적으로 우리에게 익숙한 문자로 상황을 알려주는 필드
    //result : 실제로 클라이언트에게 필요한 데이터가 담김
    @JsonProperty("isSuccess") // 이 어노테이션은 "isSuccess" 속성이 JSON에서 어떻게 표현되어야 하는지를 지정,isSuccess가 JSON 속성명과 동일하게 설정되어 있기 때문에 별도의 @JsonProperty 어노테이션이 없어도 됨
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL) // 해당 속성의 값이 null일 경우에 JSON에서 해당 속성을 제외
    private T result;


    // 성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
            return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }
}