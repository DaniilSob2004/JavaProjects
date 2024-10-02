package org.example.ticketssystem.dao.place;

import org.example.ticketssystem.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Optional<Place> findByName(String name);
}
