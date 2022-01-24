package hello.sevlet.service;

import hello.sevlet.domain.Member;
import hello.sevlet.repository.MemberRepository;
import hello.sevlet.repository.MemoryMemberRepositiry;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public  MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    회원가입
    public Long join(Member member) {
//    중복인 name제외
        validateDuplicateMember(member);
//        검색한 값을 직접꺼내고 싶다면
//        Member member1 = result.get();     그러나 별로 권장하고 싶지 않음

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m     -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
//    전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
