package jpabook.jpashop.repository.member;

import jpabook.jpashop.entity.member.Member;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@NoRepositoryBean
public class MemberJpaRepository implements MemberRepository {
    @PersistenceContext
    private EntityManager entityManager;

    //    저장할 때 원래 반환값 없지만 ID 정도 있으면 다시 조회가 가능하니 넣어준다.
    @Override
    public Long save(Member member) {
        entityManager.persist(member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        return entityManager.find(Member.class, id);
    }
}
