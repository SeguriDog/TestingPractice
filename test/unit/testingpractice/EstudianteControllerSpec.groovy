package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(EstudianteController)
@Mock(Estudiante)
class EstudianteControllerSpec extends Specification {
	def "test para numeroDeInstacias"() {
		when:
		Estudiante e1 = new Estudiante(nombre:'Carpoforo', apellido:'Guacaneme', edad:27, genero:'M', 6475834, semestre:7, codigoInst:1345236)
		Estudiante e2 = new Estudiante(nombre:'Bernabe', apellido:'Piraquive', edad:26, genero:'M', 6475857856, semestre:7, codigoInst:957856)
		e1.save()
		e2.save()
		
		then:
		controller.numeroDeInstancias() == 2
	}

}
