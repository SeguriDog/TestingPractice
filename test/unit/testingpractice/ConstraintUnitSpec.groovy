package testingpractice

/**
 * Created by jefersson on 18/10/15.
 */
import spock.lang.Specification
class ConstraintUnitSpec extends Specification {
    //Put constraints generator here.
    void validateConstraints(obj, field, error){
        def validated = obj.validate()
        if (error && error != 'valid') {
            assert !validated
            assert obj.errors[field]
            assert error == obj.errors[field]
        } else {
            assert !obj.errors[field]
        }
    }
}
