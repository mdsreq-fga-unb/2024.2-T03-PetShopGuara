import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from '../pages/Home/App';
import Login from '../pages/Login/Cadastro';
import ConsultarPet from '../pages/Pets/ConsultarPet';
import Calendario from '..pages/Pets/Calendario';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/pets" element={<ConsultarPet />} />
        <Route path="/agendar" element={<Agendar />} /> 
      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;
