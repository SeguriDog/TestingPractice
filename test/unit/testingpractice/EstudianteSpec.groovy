package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Estudiante)
class EstudianteSpec extends Specification {

     def setup() {
        mockDomain(Estudiante)
    }

    def cleanup() {
    }

    def "Se prueba el numero de semestre"(){
        when:
        def obj = new Estudiante(semestre: 24)
        obj.semestre = semestre
        obj.validate()

        then:
        obj.errors.hasFieldErrors("semestre") == !valid

        where:
        semestre | valid
         24      | false
          4      | true
    }
    
     def "Se prueba el codigo"(){
        when:
        def objc = new Estudiante(codigo: 1234)
        objc.codigo = codigo
        objc.validate()

        then:
        objc.hasErrors() == !valid

        where:
        codigo | valid
         null  | false
         123   | true
    }
    
    
}
