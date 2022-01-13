package hello.sevlet.repository;

import hello.sevlet.domain.Member;

import java.util.*;

public class MemoryMemberRepositiry implements MemberRepository{
    //    메모리를 저장할 공간을 Map을 이용해서 만든다
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
//      return store.get(id); 결과가 null일 수도 있으니까
        return Optional.ofNullable(store.get(id));  // optional을 사용해서 감싸준다 그러면 클라이언트쪽에서 뭔가를 할 수 있는데 그건 뒤에서!!
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 파라미터로 넘어온 name이랑 member에 있는 name이랑 같은 지 확인
                .findAny(); // 하나라도 찾으면 반환한다.    // 반환형은 Optional
    }

    @Override
    public List<Member> findAll() {
//        등록할 때는 map, 반환해서 사용할 때는 ArrayList를 사용한다.
        return new ArrayList<>(store.values());  // values() : Map<Long, Member>에 저장되어 있는 member의 모든 값들
    }


//    위에 구현한 로직을 검증하기 위해서는 TestCase를 작성해서 테스트를 해본다!!!!!!!!(현직에서는 당연한 것임!!!!)


}
