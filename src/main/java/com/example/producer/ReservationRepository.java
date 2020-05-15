package com.example.producer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends ReactiveMongoRepository<Reservation, String>
{
}
