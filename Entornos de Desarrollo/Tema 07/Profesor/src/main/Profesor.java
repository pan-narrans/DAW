package main;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Profesor {

  // Define la constante SUFICIENTE
  public static double SUFICIENTE = 5.00;

  // La clase sólo tiene un método
  // Acepta como entrada un objeto de tipo Alumno
  public boolean admitirAlumno(Alumno alumno) {

    // Pone en una lista las notas de las tres asignaturas
    List<Integer> notas = Arrays.asList(
        alumno.getInglesNota(),
        alumno.getHistoriaNota(),
        alumno.getMatesNota());

    OptionalDouble media = notas
        .stream() // saca un elemento de la lista
        .mapToDouble(nota -> nota) // lo convierte a double
        .average(); // hace la media

    // Si hay valores en media y la media es igual o superior a SUFICIENTE devuelve
    // true (aprobado)
    return media.isPresent() && media.getAsDouble() >= SUFICIENTE;
  }

}