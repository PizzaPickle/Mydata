package com.example.pkmydata.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MydataSecurities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mydataSecuritiesId;

    private String balance;
    private String organizationName;

    @OneToMany(mappedBy = "mydataSecurities", cascade = CascadeType.ALL)
    private List<MydataProductInSecurities> mydataProductInSecurities;

    @ManyToOne
    @JoinColumn(name = "mydata_id")
    private Mydata mydata;

    // Getters and Setters
}
