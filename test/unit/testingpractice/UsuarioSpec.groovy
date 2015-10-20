package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Usuario)
class UsuarioSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Usuario, [new Usuario(cedula:12345678)])
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
        'size'      | 'nombre'      | getLongString(1)
        'nullable'  | 'nombre'      | null
        'size'      | 'apellido'    | getLongString(70)
        'size'      | 'apellido'    | getLongString(2)
        'nullable'  | 'apellido'    | null
        'range'     | 'edad'        | getAge(false)
        'validator' | 'genero'      | getSex(false)
    }
}
