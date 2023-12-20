package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO{
        String testString;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;
    }
//public static class = DTO들은 저렇게 큰 묶음으로 클래스를 만들고, 내부적으로 static 클래스를 만드는 것이 좋습니다.
//DTO 자체는 수많은 곳에서 사용이 될 수 있기에 static class로 만들게 되면, 매번 class 파일을 만들 필요도 없고, 범용적으로 DTO를 사용 할 수 있습니다.
}
