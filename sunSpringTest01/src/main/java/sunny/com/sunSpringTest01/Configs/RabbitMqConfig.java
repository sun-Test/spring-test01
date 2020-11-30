package sunny.com.sunSpringTest01.Configs;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    @Value("${sun.rabbitmq.exchange.fanout:sun-fanout-exchange}")
    private String fanoutExchange;

    @Value("${sun.rabbitmq.exchange.queue:sun-queue}")
    private String queue;

    @Value("${sun.rabbitmq.exchange.topic.01:sun.topic.exch.01}")
    private String topicExchange01;

    @Value("${sun.rabbitmq.exchange.queue:sun.queue.01}")
    private String queue01;

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    public TopicExchange topicExchange01() {
        return new TopicExchange(topicExchange01);
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(queue, false);
    }
    @Bean
    Queue queue01() {
        return new Queue(queue01, false);
    }

    @Bean
    public Binding bindingFanout(Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    Binding bindingTopicExchange01(Queue queue01, TopicExchange topicExchange01) {
        return BindingBuilder.bind(queue01).to(topicExchange01).with("*.topic.k01");
    }

}
