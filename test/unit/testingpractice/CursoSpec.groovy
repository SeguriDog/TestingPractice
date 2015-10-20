package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(Curso)
class CursoSpec extends Specification {
    def setup() {
        mockDomain(Profesor)
        mockForConstraintsTests(Curso)
    }

    def cleanup() {
    }

    def "test-curso: min-size (3) del campo nombre"(){
        when:
        def testing = new Curso(codigo: 1007, creditos: 3, descripcion: 'materia prueba', profesor: new Profesor(oficina: 1).save())
        testing.nombre = nombre
        testing.validate()

        then:
        testing.errors.hasFieldErrors("nombre") == !valid

        where:
        nombre | valid
        'abc' | true
    }

    def "test-curso: max-size (50) del campo nombre"() {
        when:
        def test_nom_max = new Curso(codigo: 1007, creditos: 3, descripcion: 'materia uno', profesor: new Profesor(oficina: 1).save())
        test_nom_max.nombre = nombre
        test_nom_max.validate()

        then:
        test_nom_max.errors.hasFieldErrors("nombre") == !valid

        where:
        nombre                                               | valid
        "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee" | true
    }

    def "test-curso: no null del campo nombre"(){
        when:
        def test_cur_null = new Curso(codigo: 1007, creditos: 0, descripcion: 'materia uno', profesor: new Profesor(oficina: 1).save())
        test_cur_null.nombre = nombre
        test_cur_null.validate()

        then:
        test_cur_null.hasErrors() == !valid

        where:
        nombre | valid
        null | false
    }

    def "test-curso: min(1) del campo creditos"(){
        when:
        def testing = new Curso(codigo: 1007, nombre: 'nueva', descripcion: 'materia uno', profesor: new Profesor(oficina: 1).save())
        testing.creditos = credito
        testing.validate()

        then:
        testing.errors.hasFieldErrors("creditos") == !valid

        where:
        credito | valid
        1 | true
    }

    def "test-curso: max(5) del campo creditos"(){
        when:
        def testing = new Curso(codigo: 1007, nombre: 'nueva', descripcion: 'materia uno', profesor: new Profesor(oficina: 1).save())
        testing.creditos = credito
        testing.validate()

        then:
        testing.hasErrors() == !valid

        where:
        credito | valid
        6 | false
    }

    def "test-curso: obligatoria (no blank) del campo descripcion"(){
        when:
        def testing = new Curso(codigo: 1007, nombre: 'nueva', creditos: 2, profesor: new Profesor(oficina: 1).save())
        testing.descripcion = descrip
        testing.validate()

        then:
        testing.hasErrors() == !valid

        where:
        descrip | valid
        '' | false
    }

    def "test-curso: min(10)del campo descripcion"(){
        when:
        def testing = new Curso(codigo: 1007, nombre: 'nueva', creditos: 2, profesor: new Profesor(oficina: 1).save())
        testing.descripcion = descrip
        testing.validate()

        then:
        testing.hasErrors() == !valid

        where:
        descrip | valid
        'aaaaaaaaa' | false
    }
}
