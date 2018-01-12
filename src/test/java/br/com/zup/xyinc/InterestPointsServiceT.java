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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestPointsServiceT {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public InterestPointsService interestPointsService() {
            return new InterestPointsService();
        }
    }

    @Autowired
    private InterestPointsService interestPointsService;

    @Autowired
    private InterestPointsRepository interestPointsRepository;

    @Before
    public void initialize(){
        InterestPointsEntity interestPoints = new InterestPointsEntity();
        interestPoints.setId(1l);
        interestPoints.setName("Lanchonete");
        interestPoints.setCoordinateX(27l);
        interestPoints.setCoordinateY(12l);
        interestPointsRepository.save(interestPoints);

        interestPoints = new InterestPointsEntity();
        interestPoints.setId(2l);
        interestPoints.setName("Padaria");
        interestPoints.setCoordinateX(27l);
        interestPoints.setCoordinateY(12l);
        interestPointsRepository.save(interestPoints);


        interestPoints = new InterestPointsEntity();
        interestPoints.setId(3l);
        interestPoints.setName("Açougue");
        interestPoints.setCoordinateX(7l);
        interestPoints.setCoordinateY(1l);
        interestPointsRepository.save(interestPoints);

    }

    @Test
    public void findProximityPointsTest() {

        List<String> points = interestPointsService.findProximityPoints(20l, 10l, 10l);
        assertThat(points).isNotNull();
    }

}
