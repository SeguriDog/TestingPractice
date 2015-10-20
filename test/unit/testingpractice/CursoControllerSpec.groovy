package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(CursoController)
@Mock(Curso)
class CursoControllerSpec extends Specification {

	def "test para numeroDeInstacias"() {
		when:
		Curso c1 = new Curso(codigo:2345, nombre:'Mecanica Celeste IV', creditos:12, descripcion:'Esta materia es breve, relajese')
		Curso c2 = new Curso(codigo:2347, nombre:'Confeccion y Moda', creditos:1, descripcion:'Mejor cancele')
		c1.save()
		c2.save()
		
		then:
		controller.numeroDeInstancias() == 2
	}

}
