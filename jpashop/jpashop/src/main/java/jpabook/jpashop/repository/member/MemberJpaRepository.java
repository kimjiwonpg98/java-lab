package jpabook.jpashop.repository.member;

import jpabook.jpashop.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository
        extends JpaRepository<Member, Long>, MemberRepository<Member, Long> {

    //    저장할 때 원래 반환값 없지만 ID 정도 있으면 다시 조회가 가능하니 넣어준다.
    @Override
    Long save(Member member);

    @Override
    Optional<Member> findById(Long id);
}
