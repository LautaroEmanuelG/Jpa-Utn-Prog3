package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private UnidadMedida unidadMedida;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;
//    protected Set<Imagen> imagenes = new HashSet<>();

    @ManyToMany(mappedBy = "articulos")
    private Set<Promocion> promociones;
}
