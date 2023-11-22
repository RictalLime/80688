import { Button, Box, TextField } from "@mui/material"
import axios from "axios"
import { useState } from "react"

function Formulario(props) {
    const [Cargando, setCargando] = useState (false)
    const [datosFormulario, setDatosFormulario] = useState( {nombre:'', edad:'', peso:''} )

    const hacerPeticion = async () => {
        try {
            const response = await axios.get('http://localhost:4567/tipo-usuario', {params: datosFormulario})
            //const response = await axios.post('http://localhost:4567/tipo-usuario', datosFormulario)
            console.log("hacerPeticion", response)
            return response.data
        } catch (error) {
            throw error
        }
    }

    const cambiosFormulario = (evento) => {
        //console.log(evento.target)
        const {name, value} = evento.target
        setDatosFormulario( { ...datosFormulario, [name] : value })
    }

    const procesarFormulario = async (evento) => {
        evento.preventDefault()
        console.log("datos recuperados el form:", datosFormulario)
        setCargando(true)
        try {
            const response = await hacerPeticion()
            console.log("procesarFormulario", response)
            setCargando(false)
            if (datosFormulario.nombre === response.tipousuario) {
                console.log("nombre recibido.")
            } else {
                console.log("error el nombre es incorrecto")
            }
        } catch (error) {
            console.log("error", error)
            setCargando(false)
        }
    }

    return (
        <>
            <h1>Llenar Formulario</h1>
            <form onSubmit={ procesarFormulario }>
                <Box m={5}>
                    <TextField label="Nombre:" variant="outlined" fullWidth onChange={cambiosFormulario} name="nombre" value={datosFormulario.nombre}></TextField>
                </Box>
                <Box m={5}>
                    <TextField label="Edad:" variant="outlined" fullWidth onChange={cambiosFormulario} name="edad" value={datosFormulario.edad}></TextField>
                </Box>
                <Box m={5}>
                    <TextField label="Peso:" variant="outlined" fullWidth onChange={cambiosFormulario} name="peso"></TextField>
                </Box>
                <Box m={5}>
                    <Button variant="contained" type="submit" color="primary" fullWidth disabled={Cargando}>Envia</Button>
                </Box>
                
            </form>
        </>
    )
}

export default Formulario