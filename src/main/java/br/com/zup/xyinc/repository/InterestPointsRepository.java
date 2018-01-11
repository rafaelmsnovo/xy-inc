package br.com.zup.xyinc.repository;

import br.com.zup.xyinc.entity.InterestPointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestPointsRepository extends JpaRepository<InterestPointsEntity, Long> {
}
