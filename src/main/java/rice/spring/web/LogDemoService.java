package rice.spring.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import rice.spring.common.MyLogger;

@Service
public class LogDemoService {

    private final MyLogger myLogger;

    private LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String id) {
        myLogger.log("Service id = " + id);
    }
}
