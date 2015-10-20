package testingpractice

class Curso {

    long codigo
    String nombre
    int creditos
    String descripcion


    static belongsTo = [profesor: Profesor]

    static constraints = {
        codigo unique: true
        nombre size: 3..50, nullable: false
        creditos min: 1, max: 5
        descripcion blank: false, nullable: false, minSize: 10
    }
}
