package br.com.zup.xyinc.controller;

import br.com.zup.xyinc.model.NearPointsRequest;
import br.com.zup.xyinc.service.InterestPointsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class NearPointsController {

    @Autowired
    private InterestPointsService interestPointsService;

    @RequestMapping(value = "/nearPoints", method = RequestMethod.POST)
    public ResponseEntity<List<String>> findNearPoints(@RequestBody String requestJson) {
        List<String> points = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            NearPointsRequest request = mapper.readValue(requestJson, NearPointsRequest.class);
            points = interestPointsService.findProximityPoints(request.getCoordinateX(), request.getCoordinateY(), request.getDistance());
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(points, HttpStatus.OK);
    }
}
