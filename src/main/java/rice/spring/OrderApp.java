package rice.spring;

import rice.spring.member.Grade;
import rice.spring.member.Member;
import rice.spring.member.MemberService;
import rice.spring.member.MemberServiceImpl;
import rice.spring.order.Order;
import rice.spring.order.OrderService;
import rice.spring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
