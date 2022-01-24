package hello.sevlet.repository;

import hello.sevlet.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepositiry repository = new MemoryMemberRepositiry();

//    test가 끝날 때마다 레파지토리를 지워주는 메소드(콜백메소드와 같은 역할)
//    test는 서로 순서상관없이 의존관계없이 설계가 되어야하기 때문에 공용데이터들을 깔끔하게 지워줘야한다
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("sping");

        repository.save(member);

//     위에서 저장한 name이랑 (member에 저장된 name)result랑 같으면 true 아니면 false
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

//     계속 sysout으로 확인 할 수 없으니까 org.junit.jupiter.api.Assertions;의 Assertions.assertEquals(기대하는 값, 비교하는 값)을 사용해서 알아본다
//        Assertions.assertEquals(member, result);

//     요즘에는 import static org.assertj.core.api.Assertions.*;의 Assertions.assertThat을 쓴다.
        assertThat(member).isEqualTo(result);
   }

   @Test
    public void findByName(){
       Member member1 = new Member();
       member1.setName("spring1");
       repository.save(member1);

       Member member2 = new Member();
       member2.setName("spring2");
       repository.save(member2);

       Member result = repository.findByName("spring1").get();

       assertThat(result).isEqualTo(member1);
   }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
