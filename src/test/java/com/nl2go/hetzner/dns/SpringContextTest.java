package com.nl2go.hetzner.dns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HetznerDnsApiApplication.class)
public class SpringContextTest {
    
    @Test
    public void SpringContextIsBootstrappedWithoutExceptions() {
    }
}
