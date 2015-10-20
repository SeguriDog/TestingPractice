package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(ProfesorController)
@Mock(Profesor)
class ProfesorControllerSpec extends Specification {

	def "test para numeroDeInstacias"() {
		when:
		Profesor p1 = new Profesor(nombre:'Carpoforo', apellido:'Guacaneme', edad:27, genero:'M', 6475834, oficina:103)
		Profesor p2 = new Profesor(nombre:'Bernabe', apellido:'Piraquive', edad:26, genero:'M', 6475857856, oficina:405)
		p1.save()
		p2.save()
		
		then:
		controller.numeroDeInstancias() == 2
	}

}
