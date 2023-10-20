import "./MiFieldSet.jsx";
import "./DatosPersonales.jsx";
function Formulario() {
    
    return (
        <>
            <fore action>
                <MiFieldSet titulo="Datos Personales" txt1="Nombre" txt2="Password"/>
                <MiFieldSet titulo="Datos Generales" txt1="Dirección" txt2="Correo"/>
                <input type="submit" value="Enviar Datos" />
            </fore>
        </>
    )
}

export default Formulario;