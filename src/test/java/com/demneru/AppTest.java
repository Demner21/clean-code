package com.demneru;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AppTest {
  
  @BeforeAll
  static void inicializandoTest() {
    /**
     * se ejecuta antes que los demas tests
     */
    System.out.println("prueba de beforeAll");
  }

  @Test
  void allowEntryOfAnAppointment() {
    ClinicCalendar calendar = new ClinicCalendar();
    calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
    List<PatientAppointment> appointments = calendar.getAppointments();
    assertNotNull(appointments);
    assertEquals(1, appointments.size());
    PatientAppointment enteredAppt = appointments.get(0);
    assertEquals("Jim", enteredAppt.getPatientFirstName());
    assertEquals("Weaver", enteredAppt.getPatientLastName());
    assertEquals(Doctor.avery, enteredAppt.getDoctor());
    assertEquals("9/1/2018 02:00 PM",
        enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
  }
}
