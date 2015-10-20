package testingpractice

class Estudiante extends Usuario {

    int semestre
    long codigoInst


    static hasMany = [cursos: Curso]
    List cursos


    Estudiante() {
        cursos = new ArrayList();
    }

    static constraints = {
        semestre min: 1, max: 20
        codigoInst nullable: false, unique: true
		cursos nullable: false
    }
}
