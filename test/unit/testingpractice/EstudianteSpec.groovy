package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Estudiante)
class EstudianteSpec extends Specification {

   def setup() {
        mockForConstraintsTests(Estudiante, [new Estudiante(semestre:22,codigo:1234)])
    }

    def cleanup() {
    }

    void "prueba los constraints de Estudiante"() {
        when:
        def obj = new Estudiante("$field": val)

        then:
        validateContraints(obj, field, error)

        where:
        error       | field         | val
        'max'       | 'semestre'    | 22
        'nullable'  | 'codigo'      | null
    }
}
