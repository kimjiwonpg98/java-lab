package jpabook.jpashop;

import jpabook.jpashop.entity.member.Member;
import jpabook.jpashop.repository.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository<Member, Long> memberRepository;


    @Test
    @Transactional
    //    test에 트랜잭션이 있으면 rollback 해버림
//    @Rollback(false)
    public void testMember() throws Exception {
        Member member = new Member();
        member.setUsername("memberA");
        //when
        Long savedId = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(savedId);

        if (findMember.isPresent()) {
            Assertions.assertEquals(findMember.get().getId(), member.getId());
            Assertions.assertEquals(findMember.get().getUsername(), member.getUsername());
            Assertions.assertEquals(findMember, member);
        }
    }
}