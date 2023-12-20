package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.TempConverter;
import umc.study.service.TempService.TempQueryService;
import umc.study.web.dto.TempResponse;

@RestController //해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냄. 각 메서드의 반환 값은 HTTP 응답으로 처리
@RequestMapping("/temp") // 클래스 수준에서의 URL 매핑을 지정. 따라서 이 컨트롤러의 모든 메서드는 /temp 경로 아래에서 접근 가능
@RequiredArgsConstructor //클래스의 필드들을 기반으로 생성자를 생성.이를 통해 의존성 주입이 간편해짐
public class TempRestController {
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }




}
