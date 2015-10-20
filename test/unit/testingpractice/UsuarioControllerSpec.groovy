package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(UsuarioController)
@Mock(Usuario)
class UsuarioControllerSpec extends Specification {

	def "test para numeroDeInstacias"() {
		when:
		Usuario u1 = new Usuario(nombre:'Carpoforo', apellido:'Guacaneme', edad:27, genero:'M', 6475834)
		Usuario u2 = new Usuario(nombre:'Bernabe', apellido:'Piraquive', edad:26, genero:'M', 6475857856)
		u1.save()
		u2.save()
		
		then:
		controller.numeroDeInstancias() == 2
	}

}
