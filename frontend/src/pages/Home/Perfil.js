import React, { useEffect, useState } from "react";
import "./Perfil.css";
import {listarPerfil} from "../../services/APIService";

const VisualizarPerfil = () => {
  const [cliente, setCliente] = useState(null);


  const [clienteId ] = useState(localStorage.getItem('@User_id')); //Carrega o id

  useEffect(() => {
    const fetchCliente = async () => {
      try {
        const response = await listarPerfil(clienteId);
        setCliente(response);
      } catch (err) {
        console.error("Perfil não logado", err);
      }

    };
    fetchCliente();
  }, []);


  // useEffect(() => {
  //   // Mock de dados do usuário logado
  //   const mockPerfil = {
  //     nome: "exemplo",
  //     email: "exemplo@email.com",
  //     endereco: "Rua A, 123",
  //     telefone: "00000"
  //   };
  //   setPerfil(mockPerfil);
  // }, []);

  return (
    <div className="d-flex justify-content-center align-items-center perfil-details-container mt-2">
      <h2 className="pet-details-title text-center mb-4 fw-bold">Meu Perfil</h2>
      {cliente ? (
        <div className="text-center p-4 profile-box">
          <p className="profile-detail-item"><strong>Nome:</strong> {cliente.nome}</p>
          <p className="profile-detail-item"><strong>Email:</strong> {cliente.email}</p>
          <p className="profile-detail-item"><strong>Endereço:</strong> {cliente.endereco}</p>
          <p className="profile-detail-item"><strong>Telefone:</strong> {cliente.telefone}</p>
        </div>
      ) : (
        <p className="text-center">Carregando perfil...</p>
      )}
    </div>
  );
};

export default VisualizarPerfil;