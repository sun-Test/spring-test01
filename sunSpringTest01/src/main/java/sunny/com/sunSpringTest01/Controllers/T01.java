package sunny.com.sunSpringTest01.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import sunny.com.sunSpringTest01.Configs.ConfigTest01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sunny.com.sunSpringTest01.Events.RabbitEventPublisher;
import sunny.com.sunSpringTest01.Service.CustomActuatorMetricService;
import sunny.com.sunSpringTest01.Service.FileService;
import sunny.com.sunSpringTest01.Service.Serv01;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/t01")
@Slf4j
public class T01 {

    @Autowired
    ConfigTest01 configTest01;
    @Autowired
    CustomActuatorMetricService customActuatorMetricService;

    @Autowired
    private Serv01 serv01;

    @Autowired
    private FileService fileService;

    @Value("${sun.regexname}")
    private String fileNameRegex;

    @GetMapping("/paramtest01")
    public String paramtest01(@RequestParam(name="t1", required=false) String t1) {
        System.out.println(t1);
        if (t1==null) {
            System.out.println("null");
        } else {
            String [] sArry = t1.split(",");
            System.out.println("reqParam received: length: "+ sArry.length);
        }
        return "greeting";
    }

    @GetMapping("/configtest01")
    public String configtest01() {
        //Pair<String, Integer> pair = Pair("Sajal", 12);
        System.out.println(configTest01.getMyconf1().getMapping().get(configTest01.getMyconf1().getSKey1()));
        System.out.println(configTest01.getBvalue());
        System.out.println(configTest01.getListOfStrings());
        return "greeting";
    }

    @GetMapping("/test02")
    public String test02() {
        serv01.testf_file();
        return "greeting";
    }
    @GetMapping("/test03")
    public String test03() {
        return serv01.testStr001("test03");
    }

    @GetMapping("/gc")
    public String runGC() {
        System.gc();
        return "System.gc is running";
    }

    @GetMapping("/monitor")
    public String monitor01() {
        customActuatorMetricService.increaseCount(1);
        customActuatorMetricService.increaseCount(2);
        IntStream.range(1, 6).forEach(x -> customActuatorMetricService.increaseCount(3));
        customActuatorMetricService.setMetricCollectorSize(55);
        return "moni is running";
    }
    @GetMapping("/monitort1")
    public String monitor01t1() {
        customActuatorMetricService.setMetricCollectorSize(15);
        return "moni is running";
    }
    @GetMapping("/monitort2")
    public String monitor01t2() {
        customActuatorMetricService.setMetricCollectorSize(65);
        return "moni is running";
    }
    @GetMapping("/monitort3")
    public String monitor01t3() {
        List<String> l2 = customActuatorMetricService.getList();
        IntStream.range(1, 6).forEach(x -> l2.add(String.format("testStr %d", x)));
        return "moni is running";
    }


    @GetMapping("/filetest01")
    public String testFile01() {
        StringBuilder sb = new StringBuilder();
        Optional<File[]> res = fileService.getDirFilesWithRegexName("C:\\tmp\\out\\test", fileNameRegex);
        //res.ifPresent(x -> Arrays.stream(x).forEach(y -> fileService.deleteFileIfOlderThan(y, 24, false)));
        res.ifPresent(x -> Arrays.stream(x).forEach(y -> sb.append(y.toString())));
        return sb.toString();
    }

}
