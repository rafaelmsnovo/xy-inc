package br.com.zup.xyinc;

import br.com.zup.xyinc.entity.InterestPointsEntity;
import br.com.zup.xyinc.repository.InterestPointsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestPointsRepositoryT {

    @Autowired
    private InterestPointsRepository interestPointsRepository;

    @Test
    public void saveTest() {
        InterestPointsEntity interestPoints = new InterestPointsEntity();
        interestPoints.setName("Lanchonete");
        interestPoints.setCoordinateX(27l);
        interestPoints.setCoordinateY(12l);
        interestPoints = interestPointsRepository.save(interestPoints);
        assertThat(interestPoints.getId()).isNotNull();
    }

    @Test
    public void updateTest() {
        InterestPointsEntity interestPoints = interestPointsRepository.findOne(1l);
        interestPoints.setName("Test Update");
        InterestPointsEntity newInterestPoints = interestPointsRepository.save(interestPoints);
        assertThat(newInterestPoints.getName().equals("Test Update")).isTrue();
    }

    @Test
    public void removeTest() {
        interestPointsRepository.delete(1l);
        InterestPointsEntity newinterestPoints = interestPointsRepository.findOne(1l);
        assertThat(newinterestPoints).isNull();
    }
}
