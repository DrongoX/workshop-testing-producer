package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Controller
@RequiredArgsConstructor
public class ReservationController
{
  private final ReservationRepository repo;

  public Mono<ServerResponse> getAllReservations(ServerRequest serverRequest)
  {
    return ok().body(repo.findAll(), Reservation.class);
  }
}
