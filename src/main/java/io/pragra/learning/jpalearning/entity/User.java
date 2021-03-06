package io.pragra.learning.jpalearning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TABLE_USER")
@Builder
public class User {
    @Id
    private Long id;

    @Column(length = 255)
    private String name;

    @Column(name = "CREATE_DATE")
    @Builder.Default
    private Instant createDateTime = Instant.now();

    @Column(nullable = true )
    @Builder.Default
    private Instant updateDateTime = Instant.now() ;
}
