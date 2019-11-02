package ua.com.devoxx.userservice;

import io.prometheus.client.CollectorRegistry;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ConditionalOnProperty(
    value = "scheduling.enable", havingValue = "true", matchIfMissing = true
)
@Slf4j
@Configuration
@EnableDiscoveryClient
@EnableScheduling
public class BookServiceConfiguration {

  @Bean
  public String bigBean() throws InterruptedException {
    log.info("Creating an application context...");
    Thread.sleep(20_000);
    return "Done";
  }
}
