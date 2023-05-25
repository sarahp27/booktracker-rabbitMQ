package afn.xloop.booktracker_cnsd23;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@EnableRabbit
@Configuration

public class BookMsg {
    
    @Bean
    public Queue helloQueue(){
        return new Queue("This is book Tracker app");
    }
    
}
