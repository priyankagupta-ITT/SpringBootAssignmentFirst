package com.springboot.jpa.SpringBootAssignmentFirst.exceptions;

import lombok.Builder;


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
