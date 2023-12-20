package umc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// Spring boot Application 자체도 JpaAuditing 사용이 가능하도록.  스프링 데이터 JPA에서 제공하는 기능 중 하나로, 엔티티의 생성일자와 수정일자를 자동으로 관리하는 데 사용
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
