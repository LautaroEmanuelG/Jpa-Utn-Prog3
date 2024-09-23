package org.example;

import org.example.entidades.Articulo;
import org.example.entidades.Imagen;
import org.example.entidades.Promocion;
import org.example.entidades.UnidadMedida;
import org.example.enumeraciones.TipoPromocion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        System.out.println("EntityManagerFactory creado");
        try {
            //Unidad de Medida
            UnidadMedida ochoPorciones = UnidadMedida.builder()
                    .denominacion("8 Porciones")
                    .build();
            UnidadMedida cuatroPorciones = UnidadMedida.builder()
                    .denominacion("4 Porciones")
                    .build();
            UnidadMedida unLitro = UnidadMedida.builder()
                    .denominacion("1 Litro")
                    .build();

            //Persistir la Unidad de Medida
            try {
                em.getTransaction().begin();
                em.persist(ochoPorciones);
                em.persist(cuatroPorciones);
                em.persist(unLitro);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                System.out.println("Error al persistir la Unidad de Medida");
            }

            //Imágenes
            Imagen imagen1 = Imagen.builder()
                    .denominacion("Pizza grande Hawaiana")
                    .url("...")
                    .build();
            Imagen imagen2 = Imagen.builder()
                    .denominacion("Pizza grande Napolitana")
                    .url("...")
                    .build();
            Imagen imagen3 = Imagen.builder()
                    .denominacion("Pizza grande Muzza")
                    .url("...")
                    .build();
            Imagen imagen4 = Imagen.builder()
                    .denominacion("Pizza chica Hawaiana")
                    .url("...")
                    .build();
            Imagen imagen5 = Imagen.builder()
                    .denominacion("Pizza chica Napolitana")
                    .url("...")
                    .build();
            Imagen imagen6 = Imagen.builder()
                    .denominacion("Pizza chica Muzza")
                    .url("...")
                    .build();
            Imagen imagen7 = Imagen.builder()
                    .denominacion("Cerveza Andes")
                    .url("...")
                    .build();
            Imagen imagen8 = Imagen.builder()
                    .denominacion("Cerveza Quilmes")
                    .url("...")
                    .build();

            //Persistir las Imágenes
            try {
                em.getTransaction().begin();
                em.persist(imagen1);
                em.persist(imagen2);
                em.persist(imagen3);
                em.persist(imagen4);
                em.persist(imagen5);
                em.persist(imagen6);
                em.persist(imagen7);
                em.persist(imagen8);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                System.out.println("Error al persistir las imágenes");
            }

            //Imagenes Promos
            Imagen imahappy1 = Imagen.builder()
                    .denominacion("Promo Happy Hour 1")
                    .url("...")
                    .build();
            Imagen imahappy2 = Imagen.builder()
                    .denominacion("Promo Happy Hour 2")
                    .url("...")
                    .build();
            Imagen verano1 = Imagen.builder()
                    .denominacion("Promo Verano 1")
                    .url("...")
                    .build();
            Imagen verano2 = Imagen.builder()
                    .denominacion("Promo Verano 2")
                    .url("...")
                    .build();
            Imagen invierno1 = Imagen.builder()
                    .denominacion("Promo Invierno 1")
                    .url("...")
                    .build();
            Imagen invierno2 = Imagen.builder()
                    .denominacion("Promo Invierno 2")
                    .url("...")
                    .build();

            //Persistir las Imágenes de promos
            try {
                em.getTransaction().begin();
                em.persist(imahappy1);
                em.persist(imahappy2);
                em.persist(verano1);
                em.persist(verano2);
                em.persist(invierno1);
                em.persist(invierno2);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                System.out.println("Error al persistir las imágenes de promos");
            }

            //Articulos
            Articulo pizzaGrandeHawaiana = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana")
                    .precioVenta(500.0)
                    .precioCompra(250.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(ochoPorciones)
                    .imagen(imagen1)
                    .build();
            Articulo pizzaChicaHawaiana = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana")
                    .precioVenta(300.0)
                    .precioCompra(150.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(cuatroPorciones)
                    .imagen(imagen4)
                    .build();
            Articulo pizzaGrandeNapolitana = Articulo.builder()
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(500.0)
                    .precioCompra(250.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(ochoPorciones)
                    .imagen(imagen2)
                    .build();
            Articulo pizzaChicaNapolitana = Articulo.builder()
                    .denominacion("Pizza chica Napolitana")
                    .precioVenta(300.0)
                    .precioCompra(150.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(cuatroPorciones)
                    .imagen(imagen5)
                    .build();
            Articulo pizzaGrandeMuzza = Articulo.builder()
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(500.0)
                    .precioCompra(250.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(ochoPorciones)
                    .imagen(imagen3)
                    .build();
            Articulo pizzaChicaMuzza = Articulo.builder()
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(300.0)
                    .precioCompra(150.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(cuatroPorciones)
                    .imagen(imagen6)
                    .build();
            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(150.0)
                    .precioCompra(75.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(unLitro)
                    .imagen(imagen7)
                    .build();
            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(150.0)
                    .precioCompra(75.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .unidadMedida(unLitro)
                    .imagen(imagen8)
                    .build();

            //Persistir los Artículos
            try {
                em.getTransaction().begin();
                em.persist(pizzaGrandeHawaiana);
                em.persist(pizzaChicaHawaiana);
                em.persist(pizzaGrandeNapolitana);
                em.persist(pizzaChicaNapolitana);
                em.persist(pizzaGrandeMuzza);
                em.persist(pizzaChicaMuzza);
                em.persist(cervezaAndes);
                em.persist(cervezaQuilmes);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                System.out.println("Error al persistir los Artículos");
            }

            //Promociones
            Promocion promoHappyHour = Promocion.builder()
                    .denominacion("Happy Hour")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now())
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(20, 0))
                    .descripcionDescuento("Descuento del 20%")
                    .precioPromocional(520.00)
                    .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                    .articulos(Set.of(pizzaGrandeHawaiana, pizzaGrandeMuzza, cervezaQuilmes))
                    .promoImagen(Set.of(imahappy1, imagen1, imagen3, imagen8))
                    .build();
            Promocion promoVerano = Promocion.builder()
                    .denominacion("Verano")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now())
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(20, 0))
                    .descripcionDescuento("Descuento del 20%")
                    .precioPromocional(880.00)
                    .tipoPromocion(TipoPromocion.VERANO)
                    .articulos(Set.of(pizzaChicaHawaiana, pizzaGrandeNapolitana, cervezaQuilmes, cervezaAndes))
                    .promoImagen(Set.of(verano1, imagen4, imagen2, imagen7, imagen8))
                    .build();
            Promocion promoInvierno = Promocion.builder()
                    .denominacion("Invierno")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now())
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(20, 0))
                    .descripcionDescuento("Descuento del 20%")
                    .precioPromocional(760.00)
                    .tipoPromocion(TipoPromocion.INVIERNO)
                    .articulos(Set.of(pizzaGrandeHawaiana, pizzaChicaMuzza, cervezaQuilmes))
                    .promoImagen(Set.of(invierno1, imagen1, imagen6, imagen8))
                    .build();

            //Persistir las Promociones
            try {
                em.getTransaction().begin();
                em.persist(promoHappyHour);
                em.persist(promoVerano);
                em.persist(promoInvierno);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                System.out.println("Error al persistir las Promociones");
            }

            // Existing code for creating and persisting entities...

            // Mostrar todas las promociones
            try {
                System.out.println("///////////////////////////////////////");
                System.out.println("Promociones: ");
                em.createQuery("from Promocion", Promocion.class).getResultList().forEach(Main::mostrarPromo);
                System.out.println("///////////////////////////////////////");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al mostrar las promociones");
            }

            // Mostrar todos los Artículos
            try {
                System.out.println("///////////////////////////////////////");
                System.out.println("Artículos: ");
                em.createQuery("from Articulo", Articulo.class).getResultList().forEach(Main::mostrarArticulo);
                System.out.println("///////////////////////////////////////");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al mostrar los artículos");
            }

            // Mostrar cada promoción por separado y los artículos relacionados y el precio de venta
            try {
                System.out.println("///////////////////////////////////////");
                em.createQuery("from Promocion", Promocion.class).getResultList().forEach(promocion -> {
                    mostrarPromo(promocion);

                    System.out.println("Artículos de la promoción " + promocion.getDenominacion() + ": ");
                    em.createQuery("select a from Articulo a join a.promociones p where p.id = :promoId", Articulo.class)
                            .setParameter("promoId", promocion.getId())
                            .getResultList().forEach(Main::mostrarArticulo);

                    System.out.println("Precio de venta de los artículos de la promoción " + promocion.getDenominacion() + ": ");
                    em.createQuery("select a.precioVenta from Articulo a join a.promociones p where p.id = :promoId", Double.class)
                            .setParameter("promoId", promocion.getId())
                            .getResultList().forEach(precioVenta -> {
                                System.out.println("Precio Venta: " + precioVenta);
                            });
                    System.out.println("///////////////////////////////////////");
                });
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al mostrar las promociones y sus artículos");
            }

            // Mostrar el día y horario de la promoción Verano
            try {
                System.out.println("///////////////////////////////////////");
                System.out.println("Día y horario de la promoción Verano: ");
                em.createQuery("select p.fechaDesde, p.fechaHasta, p.horaDesde, p.horaHasta from Promocion p where p.denominacion = 'Verano'", Object[].class)
                        .getResultList()
                        .forEach(result -> {
                            Object[] details = (Object[]) result;
                            System.out.println("Fecha Desde: " + details[0]);
                            System.out.println("Fecha Hasta: " + details[1]);
                            System.out.println("Hora Desde: " + details[2]);
                            System.out.println("Hora Hasta: " + details[3]);
                        });
                System.out.println("///////////////////////////////////////");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al mostrar el día y horario de la promoción Verano");
            }

            // Mostrar cual es la promocion mas economica de las 3
            try {
                System.out.println("///////////////////////////////////////");
                System.out.println("Promoción más económica: ");
                em.createQuery("select p.denominacion, p.precioPromocional from Promocion p where p.precioPromocional = (select min(p2.precioPromocional) from Promocion p2)", Object[].class)
                        .getResultList()
                        .forEach(result -> {
                            Object[] details = (Object[]) result;
                            System.out.println("Denominación: " + details[0]);
                            System.out.println("Precio Promocional: " + details[1]);
                        });
                System.out.println("///////////////////////////////////////");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al mostrar la promoción más económica");
            }

        } finally {
            em.close();
            emf.close();
        }
    }

    public static void mostrarArticulo(Articulo articulo) {
        System.out.println("ID: " + articulo.getId());
        System.out.println("Denominación: " + articulo.getDenominacion());
        System.out.println("Precio Venta: " + articulo.getPrecioVenta());
        System.out.println("Precio Compra: " + articulo.getPrecioCompra());
        System.out.println("Stock Actual: " + articulo.getStockActual());
        System.out.println("Stock Máximo: " + articulo.getStockMaximo());
        System.out.println("Unidad de Medida: " + articulo.getUnidadMedida().getDenominacion());
        System.out.println("Imagen: ");
        mostrarImagen(articulo.getImagen());
    }

    public static void mostrarPromo(Promocion promocion) {
        System.out.println("ID: " + promocion.getId());
        System.out.println("Denominación: " + promocion.getDenominacion());
        System.out.println("Fecha Desde: " + promocion.getFechaDesde());
        System.out.println("Fecha Hasta: " + promocion.getFechaHasta());
        System.out.println("Hora Desde: " + promocion.getHoraDesde());
        System.out.println("Hora Hasta: " + promocion.getHoraHasta());
        System.out.println("Descripción Descuento: " + promocion.getDescripcionDescuento());
        System.out.println("Precio Promocional: " + promocion.getPrecioPromocional());
        System.out.println("Tipo Promoción: " + promocion.getTipoPromocion());
        System.out.println("Imágenes: ");
        promocion.getPromoImagen().forEach(Main::mostrarImagen);
    }

    public static void mostrarImagen(Imagen imagen) {
        System.out.println("  - ID: " + imagen.getId() + ", Denominación: " + imagen.getDenominacion() + ", URL: " + imagen.getUrl());
    }
}