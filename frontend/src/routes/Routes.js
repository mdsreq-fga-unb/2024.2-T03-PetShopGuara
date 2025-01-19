import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Cadastro from "../pages/Cadastro/cadastrarCliente";
import Cadastrar from '../pages/Login/Login'
import ConsultarPet from '../pages/Pets/ConsultarPet';
import Calendario from '../pages/Pets/Calendario';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/login" element={<Cadastrar />} />
        <Route path="/pets" element={<ConsultarPet />} />
        <Route path="/agendar" element={<Calendario/>} /> 
      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;
