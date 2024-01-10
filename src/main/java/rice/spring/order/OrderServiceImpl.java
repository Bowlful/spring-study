package rice.spring.order;

import rice.spring.discount.DiscountPolicy;
import rice.spring.member.Member;
import rice.spring.member.MemberRepository;
import rice.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice =  discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
