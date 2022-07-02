package com.amanda.devtest.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.amanda.devtest.model.entity.Username;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity<ID> extends AbstractPersistableEntity<ID> implements Serializable {
    
    private static final long serialVersionUID = -6694134167693928838L;

	@CreatedDate
    LocalDate createdDate;
    
    @LastModifiedDate
    LocalDate lastModifiedDate;
    
    @CreatedBy
    //@ManyToOne
    //@JoinColumn(name = "created_by")
    @AttributeOverride(name = "username", column = @Column(name = "created_by"))
    @Embedded
    Username createdBy;
    
    @LastModifiedBy
    //@ManyToOne
    //@JoinColumn(name = "last_modified_by")
    @AttributeOverride(name = "username", column = @Column(name = "last_modified_by"))
    @Embedded
    Username lastModifiedBy;
}
