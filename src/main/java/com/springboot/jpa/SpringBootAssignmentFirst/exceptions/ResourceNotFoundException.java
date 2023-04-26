package com.springboot.jpa.SpringBootAssignmentFirst.exceptions;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ResourceNotFoundException extends RuntimeException{
        private  String message;

        public ResourceNotFoundException(String message) {
            super(message);
            this.message = message;
        }

        public ResourceNotFoundException() {
        }

}
