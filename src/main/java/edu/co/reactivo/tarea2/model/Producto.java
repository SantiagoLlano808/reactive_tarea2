package edu.co.reactivo.tarea2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
        private Integer id;
        private String nombre;
        private String descripcion;
        private Boolean activo;
        private Integer idAlmacen;
        private String almacen;
        private Double precio;
        private Integer cantidadInventario;

        @Override
        public String toString() {
                return "{" +
                        "'id':" + id +
                        ", 'nombre':'" + nombre + '\'' +
                        ", 'descripcion':'" + descripcion + '\'' +
                        ", 'idAlmacen':" + idAlmacen +
                        ", 'almacen':" + almacen +
                        ", 'precio':" + precio +
                        ", 'cantidadInventario':" + cantidadInventario +
                        ", 'activo':" + activo +
                        '}';
        }

}
