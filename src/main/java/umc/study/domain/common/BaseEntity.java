package umc.study.domain.common;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.sql.Timestamp;

@MappedSuperclass //해당 클래스가 엔티티 클래스가 아니라 상속용으로만 사용됨을 알림, 테이블에 매핑 안됨
@EntityListeners(AuditingEntityListener.class) //엔티티 리스너 지정, 생성일자와 수정일자를 자동으로 관리
@Getter
public abstract class BaseEntity {
    @CreatedDate
    private Timestamp createdAt;

    @LastModifiedDate
    private Timestamp updatedAt;
}

