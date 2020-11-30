package sunny.com.sunSpringTest01.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.stream.StreamSupport;

@Component
@Slf4j
public class Compo001 {

    @PostConstruct
    void compoLifeCycleTestPostConstruct() {
        log.info("in the compoLifeCycleTestPostConstruct");
    }

    @PreDestroy
    void compoLifeCycleTestPreDestroy() {
        log.info("in the compoLifeCycleTestPreDestroy");
    }

    public String revertStr(String sToRevert) {
        StringBuilder input1 = new StringBuilder();
        input1.append(sToRevert);
        return input1.reverse().toString();
    }
}
