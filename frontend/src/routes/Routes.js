import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from "../pages/Home/App"; // Importa o Layou
import Cadastro from "../pages/Cadastro/cadastrarCliente";
import Cadastrar from '../pages/Login/Login'
import ConsultarPet from '../pages/Pets/ConsultarPet';
import Calendario from '../pages/Pets/Calendario';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <Routes>
      <Route path="/" element={<App />}>
        <Route path="/pets" element={<ConsultarPet />} />
        <Route path="/agendar" element={<Calendario/>} /> 
        </Route>
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/login" element={<Cadastrar />} />
      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;
