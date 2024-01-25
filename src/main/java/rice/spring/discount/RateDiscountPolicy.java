package rice.spring.discount;

import org.springframework.stereotype.Component;
import rice.spring.member.Grade;
import rice.spring.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPolicy = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return  price * discountPolicy / 100;
        } else {
            return 0;
        }
    }
}
