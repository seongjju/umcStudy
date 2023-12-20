package umc.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Terms;
import umc.study.domain.common.BaseEntity;

@Entity //해당 클래스가 JPA 엔터티임을 나타내는 애노테이션. 데이터 테이블에 매핑됨
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터 없는 기본 생성자를 생성, JPA에서는 기본 생성자가 필요하므로 엔터티 클래스에는 주로 사용
@AllArgsConstructor
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동으로 생성하도록 하는 애노테이션. 데이터베이스가 자동으로 값을 생성하는 IDENTITY 전략을 사용
    private Long id;

    @ManyToOne(fetch =  FetchType.LAZY) //현재클래스와 Member 클래스 간의 다일관계 설정
    @JoinColumn(name= "member_id") //외래키 이름 설정
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;

    //연관관계주인 = 외래키 가지는 엔티티(테이블) 단방향 매핑: 연관관계 주인에만 연관 관계 주입
    //양방향 매핑: 아닌 엔티티에게도 연관 관계 주입
    //DB에서 cascade는 연관 관계의 주인 테이블에 설정, 참조 테이블 칼럼이 삭제,변경될 때 동일하게 삭제,변경
    //단방향 매핑만 적용된 상태에서 cascade 설정하면, member 참조하는 review가 삭제 될 때 member도 같이 삭제 됨.
    //양방향 매핑 시 연관 관계 편의 메서드 필요

}

