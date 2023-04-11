package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Map<Grade, Member> gradeStore = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
        gradeStore.put(member.getGrade(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public Member findByGrade(Grade grade) {
        return gradeStore.get(grade);
    }
}
