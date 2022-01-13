package hello.sevlet.repository;

import hello.sevlet.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null을 그대로 반환하기 보다는 Optional로 감싸서 반환하는 방법을 선호하는 편(java8에 들어가있는 기능)
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
