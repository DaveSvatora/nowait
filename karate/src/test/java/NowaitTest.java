package test.java.nowait;

import com.intuit.karate.junit5.Karate;

class NowaitTest {
    
    @Karate.Test
    Karate testEvent() {
        return Karate.run("classpath:event.feature");
    }
    
}