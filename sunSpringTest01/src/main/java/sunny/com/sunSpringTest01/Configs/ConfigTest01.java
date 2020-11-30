package sunny.com.sunSpringTest01.Configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "someprefix", ignoreInvalidFields = true)
@Data
public class ConfigTest01 {

    @Value("${someprefix.bvalue:true}")
    private Boolean bvalue;

    private Integer intValue = 0;
    private List<String> listOfStrings;
    private Myconf1 myconf1 = new Myconf1();

    @Data
    public static class Myconf1 {
        private int iSome1;
        private int iSome2;
        private int iSome3 = 0;
        private String sKey1;
        private Map<String, Integer> mapping = new HashMap<>();
    }
}
