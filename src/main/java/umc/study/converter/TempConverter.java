package umc.study.converter;

import umc.study.web.dto.TempResponse;

public class TempConverter {


    //TempTestDTO 객체를 생성하고, 그 중 testString 필드에 ("This is Test!")값 설정 하여 최종적으로 반환하는 메서드
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder() //빌더(객체 생성과정을 단순화시킴) 생성
                .testString("This is Test!")
                .build();
    }
    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }

}
