package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("MemberA");

        //when
        Long saveId = memberRepository.save(member);
        Member member1 = memberRepository.find(saveId);

        //then
        assertThat(member1.getId()).isEqualTo(member.getId());
        assertThat(member1.getUsername()).isEqualTo(member.getUsername());
        assertThat(member).isEqualTo(member1);

    }
}