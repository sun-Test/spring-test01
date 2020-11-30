package ServiceTest;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sunny.com.sunSpringTest01.Configs.ConfigTest01;
import sunny.com.sunSpringTest01.Service.Serv01;

//@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ConfigTest01.class })
@Ignore
public class ServTest01 {

    private static SessionFactory sessionFactory;

    public Serv01 serv01 = new Serv01();

    @Test
    public void testF_Serv() {
        serv01.testf_file();
        System.out.println("imtest");
    }
}
