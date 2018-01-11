package br.com.zup.xyinc.service;

import br.com.zup.xyinc.entity.InterestPointsEntity;
import br.com.zup.xyinc.repository.InterestPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InterestPointsService {

    @Autowired
    private InterestPointsRepository interestPointsRepository;


    public List<String> findProximityPoints(Long coordinateX, Long coordinateY, Long distance){
        List<String> points = new ArrayList<String>();
        for (InterestPointsEntity interestPointsEntity : interestPointsRepository.findAll()){
            if(getDistancia(interestPointsEntity.getCoordinateX(), interestPointsEntity.getCoordinateY(), coordinateX, coordinateY)<= distance) {
                points.add(interestPointsEntity.getName());
            }
        }
        return points;
    }


    private double getDistancia(double latitude, double longitude, double latitudePto, double longitudePto){
        double dlon, dlat, a, distancia;
        dlon = longitudePto - longitude;
        dlat = latitudePto - latitude;
        a = Math.pow(Math.sin(dlat/2),2) + Math.cos(latitude) * Math.cos(latitudePto) * Math.pow(Math.sin(dlon/2),2);
        distancia = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return 6378140 * distancia; /* 6378140 is the radius of the Earth in meters*/
    }
}
