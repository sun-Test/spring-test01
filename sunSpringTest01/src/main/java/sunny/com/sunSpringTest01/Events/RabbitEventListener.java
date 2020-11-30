package sunny.com.sunSpringTest01.Events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitEventListener {

    @RabbitListener(queues = "sun-queue")
    public void receiveFanout(String msg) {
        log.info("RabbitListener: msg received: {}", msg);
    }
    @RabbitListener(queues = "sun.queue.01")
    public void receiveTopic01(String msg) {
        log.info("RabbitListener: Topic01: msg received: {}", msg);
    }
}
