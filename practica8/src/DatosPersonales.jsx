
function DatosPersonales() {
    return (
        <>
            <fieldset>
                <legend>{Datos Personales}</legend>
                <label htmlFor>: </label>
                <input type="text" id={txt1}/>
                <label htmlFor={txt2}>{txt2}: </label>
                <input type="password" id={txt2}/>
            </fieldset>
        </>
    )
}