package com.ali.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class Book extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String page;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

}