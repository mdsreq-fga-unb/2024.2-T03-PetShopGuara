import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from "../pages/Home/App"; // Importa o Layou
import Home from "../pages/Home/Home";
import Cadastro from "../pages/Cadastro/cadastrarCliente";
import Cadastrar from '../pages/Login/Login'
import CadastrarPet from '../pages/Pets/CadastrarPet';
import ConsultarPet from '../pages/Pets/ConsultarPet';
import Calendario from '../pages/Pets/Calendario';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <Routes>
      <Route path="/" element={<App/>}>
        <Route path="/" element={<Home/>} />
        <Route path="/pets" element={<ConsultarPet/>} />
        <Route path="/cadastropets" element={<CadastrarPet/>} />
        <Route path="/agendar" element={<Calendario/>} /> 
        </Route>
        <Route path="/cadastro" element={<Cadastro/>} />
        <Route path="/login" element={<Cadastrar/>} />
      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;
