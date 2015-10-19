package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Usuario)
class UsuarioSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Usuario, [new Usuario(cedula:)])
    }

    def cleanup() {
    }

    @Unroll("prueba todas las contraints de usuario #field es #error")
    void "prueba los constraints de usuario"() {
        when:
        def obj = new Usuario("$field": val)

        then:
        validateContraints(obj, field, error)

        where:
        error       | field         | val
        'size'      | 'nombre'      | getLongString(56)
        'nullable'  | 'nombre'      | null
    }
}
