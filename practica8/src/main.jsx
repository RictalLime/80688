import React from 'react'
import ReactDOM from 'react-dom/client'
// import App from './App.jsx'
import MiFieldSet from './index.html'
import Formulario from './index.html'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <MiFieldSet titulo="Datos Personales" txt1="Nombre" txt2="Password"/>
    <MiFieldSet titulo="Datos Generales" txt1="Dirección" txt2="Correo"/>
    <input type="submit" value="Enviar Datos" />
  </React.StrictMode>,
)
