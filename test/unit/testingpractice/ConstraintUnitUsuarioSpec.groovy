
import spock.lang.Specification

abstract class ConstraintUnitUsuarioSpec extends Specification {
    String getLongString(Integer length) {
        'a' * length
    }

    String getAge(Boolean valid) {
        valid ? 21 : 5
    }

    String getSex(Boolean valid) {
        valid ? "F" : "W"
    }

    void validateConstraints(obj, field, error) {
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
