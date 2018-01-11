package br.com.zup.xyinc.repository;

import br.com.zup.xyinc.entity.PoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends JpaRepository<PoiEntity,Long> {
}
