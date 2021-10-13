package com.service.core.model.entity.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "config", name = "parameter_item")
public class ParameterItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "parameter_id")
    private Long parameterId;
    @Column(name = "approved")
    private Integer approved;
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "description")
    private String description;
    @Column(name = "\"order\"")
    private Integer order;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    void prePersist() {
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.createdDate = new Date();
    }

    @PreUpdate
    void preUpdate() {
        this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.updatedDate = new Date();
    }
}
