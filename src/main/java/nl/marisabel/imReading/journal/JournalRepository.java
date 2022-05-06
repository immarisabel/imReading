package nl.marisabel.imReading.journal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntity, Integer> {
}
