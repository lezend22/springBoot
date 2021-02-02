package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//interface가 interface 받으면 extends
//springDataJpaMemberRepository는 interface만 있는상태 JpaRepository extend된걸 보고
//springDataJpa가 알아서 구현체까지만들어 springBean에 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
