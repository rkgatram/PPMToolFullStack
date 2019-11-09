package com.rkgatram.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravikumar.g
 * Date 2019-11-09
 */
@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {

        if(result.hasErrors()){

            Map<String, String> errorMap = new HashMap<>();

            result.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
