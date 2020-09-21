package com.example.my_security.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_permission")
public class Permission extends BaseEntity {
    private String permissionName;

    private String permissionKey;
}
