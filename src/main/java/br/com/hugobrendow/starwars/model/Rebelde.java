package br.com.hugobrendow.starwars.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Rebelde {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    private String nome;
    private Integer idade;
    private Genero genero;
    private Integer acusacoes = 0;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Localizacao localizacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Inventario inventario;
}
