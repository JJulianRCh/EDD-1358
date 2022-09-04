/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package EdD.Tarea3;

public class Empleado {

    private static final float HORA_EXTRA = 276.5f;
    private int NumDeTrabajador;
    private String nombre;
    private String paterno;
    private String materno;
    private float sueldoBase;
    private int horasExtras;
    private int añoDeIngreso;

    public Empleado(int NumDeTrabajador, String nombre, String paterno, String materno,
            int horasExtras, float sueldoBase, int añoDeIngreso) {
        this.NumDeTrabajador = NumDeTrabajador;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
        this.añoDeIngreso = añoDeIngreso;
    }

    /**
     * Devuelve el id del Empleado
     *
     * @return NumDeTrabajador
     */
    public int getNumDeTrabajador() {
        return NumDeTrabajador;
    }

    /**
     * Modificar el numero del Trabajador
     *
     * @param NumDeTrabajador El numero para identificar al Empleado
     */
    public void setNumDeTrabajador(int NumDeTrabajador) {
        this.NumDeTrabajador = NumDeTrabajador;
    }

    /**
     * Devuelve el nombre del empleado
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modificar el nombre del empleado
     *
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido paterno del empleado
     *
     * @return apellido paterno
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * Modificar el appellido paterno del empleado
     *
     * @param paterno el nuevo apellido paterno
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     * Devuelve el apellido materno del empleado
     *
     * @return apellido materno
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * Modificar el apellido materno del empleado
     *
     * @param materno el nuevo apellido materno
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * Devuelde el sueldo base que tiene el empleado
     *
     * @return sueldo base
     */
    public float getSueldoBase() {
        return sueldoBase;
    }

    /**
     * Modificar el sueldo base del empleado
     *
     * @param sueldoBase el nuevo sueldo
     */
    public void setSueldoBase(float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    /**
     * Devuelve las horas extras laboradas por el empleado
     *
     * @return horas extras
     */
    public int getHorasExtras() {
        return horasExtras;
    }

    /**
     * Cambiar las horas extras laboradas
     *
     * @param horasExtras las nuevas horas extras trabajadas
     */
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    /**
     * El año en el que empleado ingleso a la empresa
     *
     * @return año de ingreso
     */
    public int getAñoDeIngreso() {
        return añoDeIngreso;
    }

    /**
     * Modificar el año de ingreso
     *
     * @param añoDeIngreso el nuevo año de ingreso
     */
    public void setAñoDeIngreso(int añoDeIngreso) {
        this.añoDeIngreso = añoDeIngreso;
    }

    /**
     * El sueldo final que se le dara el empleado a partir de su sueldo base,
     * las horas extras trabajadas y la antigüedad que lleva en la empresa
     *
     * @return sueldo final
     */
    public float calcularSueldo() {
        float antiguedad = (2022 - añoDeIngreso) * 0.3f;
        float sueldo = sueldoBase + (sueldoBase * antiguedad) + (horasExtras * HORA_EXTRA);
        return sueldo;
    }

    /**
     * El estado actual del objeto
     *
     * @return estado
     */
    @Override
    public String toString() {
        String estado = "";
        estado += NumDeTrabajador + "\n";
        estado += nombre + "\n";
        return estado;
    }
}
