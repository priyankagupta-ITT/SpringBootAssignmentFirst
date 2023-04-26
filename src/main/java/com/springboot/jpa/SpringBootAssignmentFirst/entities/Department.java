package com.springboot.jpa.SpringBootAssignmentFirst.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private int id;


    @Column(name= "dept_name")
    private String dname;


    @Column(name = "active_status")
    private String activeStatus;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Employee> employeeList;

}
