package br.com.zup.xyinc;

import br.com.zup.xyinc.repository.InterestPointsRepository;
import br.com.zup.xyinc.service.InterestPointsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class InterestPointsServiceT {

    @Autowired
    private InterestPointsService interestPointsService;

    @Autowired
    private InterestPointsRepository interestPointsRepository;

    @Test
    public void findProximityPointsTest() {

        List<String> points = interestPointsService.findProximityPoints(20l, 10l, 10l);
        assertThat(points).isNotNull();
    }

}
