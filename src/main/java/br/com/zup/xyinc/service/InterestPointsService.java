package br.com.zup.xyinc.service;

import br.com.zup.xyinc.entity.InterestPointsEntity;
import br.com.zup.xyinc.repository.InterestPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InterestPointsService {

    @Autowired
    private InterestPointsRepository interestPointsRepository;

    public List<String> findProximityPoints(Long coordinateX, Long coordinateY, Long distanceMax) {
        List<String> points = new ArrayList<String>();
        for (InterestPointsEntity point : interestPointsRepository.findAll()) {
            Double distance = calculateDistance(point.getCoordinateX(), point.getCoordinateY(), coordinateX, coordinateY);
            if (distanceMax >= distance) {
                points.add(point.getName());
            }
        }
        return points;
    }

    private Double calculateDistance(Long xA, Long yA, Long xB, Long yB) {
        Double dX = Math.pow(xB - xA, 2);
        Double dY = Math.pow(yB - yA, 2);
        Double distance = Math.sqrt(dX + dY);
        return distance;
    }
}
