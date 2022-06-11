package com.ali.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class Author extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1364638568458L;


    private String name;


}