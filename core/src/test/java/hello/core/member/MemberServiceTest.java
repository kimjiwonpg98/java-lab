package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given (환경이 주어졌을 떄)
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when (했을 떄)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then (결과)
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void gradeJoin() {
        //given (환경이 주어졌을 떄)
        Member member = new Member(1L, "memberB", Grade.VIP);
        //when (했을 떄)
        memberService.join(member);
        Member findMember = memberService.findMemberGrade(Grade.VIP);
        //then (결과)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
