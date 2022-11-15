package net.yorksolutions.kabornamarracapstonebe.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

}
