package rice.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rice.spring.discount.DiscountPolicy;
import rice.spring.discount.RateDiscountPolicy;
import rice.spring.member.MemberRepository;
import rice.spring.member.MemberService;
import rice.spring.member.MemberServiceImpl;
import rice.spring.member.MemoryMemberRepository;
import rice.spring.order.OrderService;
import rice.spring.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
