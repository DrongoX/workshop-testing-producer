package com.example.producer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@WebFluxTest
@Import(ReservationRouter.class)
public class ReservationApiTest
{
  @Autowired
  WebTestClient webTestClient;

  @MockBean
  ReservationRepository repo;

  @Test
  @DisplayName("Should get all reservation")
  void should_get_all_reservation()
  {
    //given
    when(repo.findAll()).thenReturn(Flux.just(new Reservation("1", "Joris")));
    //when
    webTestClient.get()
                 .uri("/reservations")
                 .exchange()
    //then
                 .expectStatus().isOk()
                 .expectHeader().contentType(MediaType.APPLICATION_JSON)
                 .expectBody().jsonPath("@.[0].name").value(equalTo("Joris"));
  }
}
