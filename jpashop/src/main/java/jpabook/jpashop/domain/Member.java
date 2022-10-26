package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // 시퀀스 , 스퀀스 자동입력
    @Column(name = "member_id") // 데이터베이스 테이블명으로 바꿔줄려고 씀
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //1대다
    private List<Order> orders = new ArrayList<>();
}
