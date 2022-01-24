package hello.sevlet.service;

import hello.sevlet.domain.Member;
import hello.sevlet.repository.MemoryMemberRepositiry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepositiry memberRepositiry;
    @BeforeEach
    public void beforeEach() {
        memberRepositiry = new MemoryMemberRepositiry();
        memberService = new MemberService(memberRepositiry);
    }

    @AfterEach
    public void afterEach() {
        memberRepositiry.clearStore();
    }

    @Test
    void 회원가입() {
//      given 어떤 데이터가 주어지고
        Member member = new Member();
        member.setName("hello");

//      when 이러한 상황일 떄 / 데이터를 가지고 이걸 실행했을 때 / 이런 걸 검증하고 싶을 때
        Long saveId = memberService.join(member);

//      then 이런 결과가 나와야한다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
//      given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

//      when
        memberService.join(member1);
        // 오른쪽 로직을 실행할 때 이 예외가 터져야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

//      then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}