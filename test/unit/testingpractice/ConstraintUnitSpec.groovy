package testingpractice

/**
 * Created by jefersson on 18/10/15.
 */
import spock.lang.Specification
class ConstraintUnitSpec extends Specification {

    String getLongString(Integer length) {
        'a' * length
    }

    String getSex(Boolean valid) {
        valid ? "F" : "W"
    }

    String getAge(Boolean valid) {
        valid ? 21 : 5
    }

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
