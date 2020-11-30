package sunny.com.sunSpringTest01.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomActuatorMetricService {
    @Autowired
    private MeterRegistry registry;

    private final List<ArrayList<Integer>> statusMetricsByMinute = new ArrayList<>();
    private final List<String> statusList = new ArrayList<>();
    private final String collectorSize01 = "number.gauge01";
    private List<String> l2 = null;

    private AtomicInteger myGauge = null;

    public void setMetricCollectorSize(Integer setVal) {

        if (myGauge == null) {
            myGauge = registry.gauge(collectorSize01, new AtomicInteger(0));
        }
        myGauge.set(setVal);
    }

    public List<String> getList() {

        if (l2 == null) {
            l2 = registry.gauge("listGauge", Collections.emptyList(), new ArrayList<>(), List::size);
        }
        return l2;
    }

    public void increaseCount(final int status) {
        String counterName = "counter.status." + status;
        registry.counter(counterName).increment(1);
        if (!statusList.contains(counterName)) {
            statusList.add(counterName);
        }
    }

    @Scheduled(fixedDelay = 2000) // milli sec
    private void exportMetrics() {
        final ArrayList<Integer> statusCount = new ArrayList<Integer>();
        for (final String status : statusList) {
            Search search = registry.find(status);
            if (search != null) {
                Counter counter = search.counter();
                statusCount.add(counter != null ? ((int) counter.count()) : 0);
                registry.remove(counter);
            } else {
                statusCount.add(0);
            }
        }
        statusMetricsByMinute.add(statusCount);
    }

}
