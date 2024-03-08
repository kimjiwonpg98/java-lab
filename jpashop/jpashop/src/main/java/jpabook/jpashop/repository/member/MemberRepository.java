package jpabook.jpashop.repository.member;

import jpabook.jpashop.entity.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface MemberRepository {

//    저장할 때 원래 반환값 없지만 ID 정도 있으면 다시 조회가 가능하니 넣어준다.
    public Long save(Member member);

    public Member findById(Long id);
}
