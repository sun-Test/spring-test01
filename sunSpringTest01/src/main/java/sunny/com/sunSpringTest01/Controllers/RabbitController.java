package sunny.com.sunSpringTest01.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sunny.com.sunSpringTest01.Events.RabbitEventPublisher;

@RestController
@RequestMapping("/rabbit")
@Slf4j
public class RabbitController {

    @Autowired
    private RabbitEventPublisher rabbitEventPublisher;

    @GetMapping("/test01")
    public String testRabbit01() {
        rabbitEventPublisher.publishFanout("this is a fanout test message");
        rabbitEventPublisher.publishTopic01("this is topic test message with routing key sun.topic.k01");
        return "hello rabbit";
    }
}
