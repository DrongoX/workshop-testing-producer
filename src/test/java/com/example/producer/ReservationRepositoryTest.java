package com.example.producer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class ReservationRepositoryTest
{
  @Autowired
  ReservationRepository repo;


  @Test
  @DisplayName("Should save reservation and generate ID")
  void should_save_reservation_and_generate_id()
  {
    //given
    Reservation reservation = new Reservation(null, "Joris");
    //when
    Mono<Reservation> saved = repo.save(reservation);
    //then
    StepVerifier.create(saved)
                .assertNext(r -> {
                  Assertions.assertThat(r.getId()).isNotNull();
                  Assertions.assertThat(r.getName()).isEqualTo("Joris");
                })
                .verifyComplete();
  }
}
