package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro2;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ciudadano c1 = this.ciudadanoService.buscarPorApellidoCAQ("Valladares");
		System.out.println(c1);

//		Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_cedula=?
//		Hibernate: select e1_0.empl_id,c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre,e1_0.empl_fecha_ingreso,e1_0.empl_salario from empleado e1_0 left join ciudadano c1_0 on c1_0.ciud_id=e1_0.empl_id_ciudadano where e1_0.empl_id_ciudadano=?
		Ciudadano c2 = this.ciudadanoService.buscarPorCriteria("Luis", "Valladares", "12345");
		System.out.println(c2);

//		Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_apellido=?
//		Hibernate: select e1_0.empl_id,c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre,e1_0.empl_fecha_ingreso,e1_0.empl_salario from empleado e1_0 left join ciudadano c1_0 on c1_0.ciud_id=e1_0.empl_id_ciudadano where e1_0.empl_id_ciudadano=?		
		Ciudadano c3 = this.ciudadanoService.buscarPorCriteria("Luis", "Valladares", "05554545");
		System.out.println(c3);

//		Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_cedula=?
//		Ciudadano c4 = this.ciudadanoService.buscarPorCriteria("Luis", "Valladares", "0622554545");
//		System.out.println(c4);
		
//		Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=? and c1_0.ciud_apellido=?
//		Hibernate: select e1_0.empl_id,c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre,e1_0.empl_fecha_ingreso,e1_0.empl_salario from empleado e1_0 left join ciudadano c1_0 on c1_0.ciud_id=e1_0.empl_id_ciudadano where e1_0.empl_id_ciudadano=?

		System.out.println("CRITERIA API QUERY AND OR");
		Ciudadano c4 = this.ciudadanoService.buscarPorCriteriaAndOr("Luis", "Valladares", "05345");
		System.out.println(c4);
	}

}
