package rice.spring.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServeiceTest {
    
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefullServeice statefullServeice1 = ac.getBean(StatefullServeice.class);
        StatefullServeice statefullServeice2 = ac.getBean(StatefullServeice.class);
        
        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefullServeice1.order("userA", 10000);

        //ThreadA: B사용자 20000원 주문
        int userBPrice = statefullServeice2.order("userB", 20000);

//        int price = statefullServeice1.getPrice();
        System.out.println("price = " + userAPrice);

//        assertThat(statefullServeice1.getPrice()).isEqualTo(20000);
    }
    
    static class TestConfig {
        
        @Bean
        public StatefullServeice statefullServeice() {
            return new StatefullServeice();
        }
    }
    
}