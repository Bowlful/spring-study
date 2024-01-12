package rice.spring;

import rice.spring.discount.FixDiscountPolicy;
import rice.spring.member.MemberService;
import rice.spring.member.MemberServiceImpl;
import rice.spring.member.MemoryMemberRepository;
import rice.spring.order.OrderService;
import rice.spring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
