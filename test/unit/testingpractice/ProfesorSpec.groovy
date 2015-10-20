package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Profesor)
class ProfesorSpec extends ConstraintUnitSpec {

    def setup() {
		mockForConstraintsTest(Profesor, [new Profesor(oficina: 1)])
    }

    def cleanup() {
    }

    def "test Profesor all constraints"() {
		when:
		def obj = new Profesor("$field", val)

		then:
		validateConstraints(obj, field, error)

		where:
		error 	| field		| val
		'min'	| oficina	| 0
		'max'	| oficina	| 51
		'unique'| oficina	| 1 
    }
}
