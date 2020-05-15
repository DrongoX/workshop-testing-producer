package com.example.producer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ContractTestBase
{
  @LocalServerPort
  private int port;

  @MockBean
  ReservationRepository repo;

  @BeforeEach
  void setup() {
    RestAssured.baseURI = "http://localhost:" + port;
    when(repo.findAll()).thenReturn(Flux.just(new Reservation("1", "Joris")));
  }
}
