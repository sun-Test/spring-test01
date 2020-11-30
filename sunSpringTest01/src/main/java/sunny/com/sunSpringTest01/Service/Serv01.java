package sunny.com.sunSpringTest01.Service;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
@Slf4j
public class Serv01 {
    @Autowired
    Compo001 compo001;

    public void testf_file() {
        try {
            //File file = new File("C:\\tmp\\inputs\\P110_VESD.xml");
            FileInputStream fis = new FileInputStream("C:\\mp\\inputs\\P110_VESD.xml");
            String data = IOUtils.toString(fis, "UTF-8");
            System.out.println(data);
        } catch (FileNotFoundException e) {

            log.info("testf_file: test slf4j: {}", ExceptionUtils.getStackTrace(e));
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String testStr001(String somStr) {
        return compo001.revertStr(somStr);
    }

    @PostConstruct
    void servLifeCycleTestPostConstruct() {
        log.info("in the servLifeCycleTestPostConstruct");
    }

    @PreDestroy
    void servLifeCycleTestPreDestroy() {
        log.info("in the servLifeCycleTestPreDestroy");
    }
}
