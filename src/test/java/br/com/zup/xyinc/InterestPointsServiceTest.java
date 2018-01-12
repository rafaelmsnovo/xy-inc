package br.com.zup.xyinc;

import br.com.zup.xyinc.entity.InterestPointsEntity;
import br.com.zup.xyinc.repository.InterestPointsRepository;
import br.com.zup.xyinc.service.InterestPointsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InterestPointsServiceTest {

    @Autowired
    private InterestPointsService interestPointsService;
    @Autowired
    private InterestPointsRepository interestPointsRepository;

    @Before
    public void initialize() {
        InterestPointsEntity interestPoints = new InterestPointsEntity();
        interestPoints.setId(1l);
        interestPoints.setName("Lanchonete");
        interestPoints.setCoordinateX(27l);
        interestPoints.setCoordinateY(12l);
        interestPointsRepository.save(interestPoints);

        interestPoints = new InterestPointsEntity();
        interestPoints.setId(2l);
        interestPoints.setName("Posto");
        interestPoints.setCoordinateX(31l);
        interestPoints.setCoordinateY(18l);
        interestPointsRepository.save(interestPoints);


        interestPoints = new InterestPointsEntity();
        interestPoints.setId(3l);
        interestPoints.setName("Joalheria");
        interestPoints.setCoordinateX(15l);
        interestPoints.setCoordinateY(12l);
        interestPointsRepository.save(interestPoints);

        interestPoints = new InterestPointsEntity();
        interestPoints.setId(4l);
        interestPoints.setName("Floricultura");
        interestPoints.setCoordinateX(19l);
        interestPoints.setCoordinateY(21l);
        interestPointsRepository.save(interestPoints);

        interestPoints = new InterestPointsEntity();
        interestPoints.setId(5l);
        interestPoints.setName("Pub");
        interestPoints.setCoordinateX(12l);
        interestPoints.setCoordinateY(8l);
        interestPointsRepository.save(interestPoints);

        interestPoints = new InterestPointsEntity();
        interestPoints.setId(6l);
        interestPoints.setName("Supermercado");
        interestPoints.setCoordinateX(23l);
        interestPoints.setCoordinateY(6l);
        interestPointsRepository.save(interestPoints);

        interestPoints = new InterestPointsEntity();
        interestPoints.setId(7l);
        interestPoints.setName("Churrascaria");
        interestPoints.setCoordinateX(28l);
        interestPoints.setCoordinateY(2l);
        interestPointsRepository.save(interestPoints);

    }

    @Test
    public void findProximityPointsTest() {

        List<String> points = interestPointsService.findProximityPoints(20l, 10l, 10l);
        assertThat(points).isNotEmpty();
        assertThat(points.size()).isEqualTo(4);
        assertThat(points.get(0)).isEqualToIgnoringCase("Lanchonete");
        assertThat(points.get(1)).isEqualToIgnoringCase("Joalheria");
        assertThat(points.get(2)).isEqualToIgnoringCase("Pub");
        assertThat(points.get(3)).isEqualToIgnoringCase("Supermercado");
    }

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public InterestPointsService interestPointsService() {
            return new InterestPointsService();
        }
    }

}
