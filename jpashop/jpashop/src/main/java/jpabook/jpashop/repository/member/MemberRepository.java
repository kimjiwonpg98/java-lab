package jpabook.jpashop.repository.member;

import jpabook.jpashop.entity.member.Member;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface MemberRepository<T, ID> extends Repository<T, ID> {

//    저장할 때 원래 반환값 없지만 ID 정도 있으면 다시 조회가 가능하니 넣어준다.
    Long save(Member member);

    Optional<Member> findById(Long id);
}
