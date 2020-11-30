package sunny.com.sunSpringTest01.Events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitEventPublisher {

    @Autowired
    private TopicExchange topicExchange01;

    @Autowired
    private FanoutExchange fanout;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void publishFanout(String msg) {
        amqpTemplate.convertAndSend(fanout.getName(), "", msg);
    }

    public synchronized void publishTopic01(String someEvent) {
        amqpTemplate.convertAndSend(topicExchange01.getName(), "sun.topic.k01", someEvent);
    }

}
