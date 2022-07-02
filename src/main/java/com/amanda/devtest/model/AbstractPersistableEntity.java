package com.amanda.devtest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@MappedSuperclass
public abstract  class AbstractPersistableEntity<ID> implements Serializable {

    private static final long serialVersionUID = -8268042056088184965L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;

    @Version
    private Long version;
}
