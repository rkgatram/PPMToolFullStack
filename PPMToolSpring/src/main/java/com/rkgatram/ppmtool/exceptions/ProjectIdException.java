package com.rkgatram.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ravikumar.g
 * Date 2019-11-09
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

    public ProjectIdException(String message) {
        super(message);
    }
}
