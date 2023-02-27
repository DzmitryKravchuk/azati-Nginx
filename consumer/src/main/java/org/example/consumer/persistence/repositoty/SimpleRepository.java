package org.example.consumer.persistence.repositoty;

import org.example.consumer.persistence.entity.SimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleRepository extends JpaRepository <SimpleEntity, Long> {
}
