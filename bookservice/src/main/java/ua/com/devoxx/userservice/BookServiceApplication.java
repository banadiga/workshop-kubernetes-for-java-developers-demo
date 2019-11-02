package ua.com.devoxx.userservice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@SpringBootApplication
public class BookServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookServiceApplication.class, args);
  }

  @Scheduled(initialDelay = 300_000, fixedDelay = 1_000)
  public void shutdown() {
    log.error("something going wrong)");
    System.exit(13);
  }
}
