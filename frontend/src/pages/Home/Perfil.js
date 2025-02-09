import React, { useEffect, useState } from "react";
import "./Perfil.css";

const VisualizarPerfil = () => {
  const [perfil, setPerfil] = useState(null);

  useEffect(() => {
    // Mock de dados do usuário logado
    const mockPerfil = {
      nome: "exemplo",
      email: "exemplo@email.com",
      endereco: "Rua A, 123",
      telefone: "00000"
    };
    setPerfil(mockPerfil);
  }, []);

  return (
    <div className="d-flex justify-content-center align-items-center perfil-details-container mt-2">
      <h2 className="pet-details-title text-center mb-4 fw-bold">Meu Perfil</h2>
      {perfil ? (
        <div className="text-center p-4 profile-box">
          <p className="profile-detail-item"><strong>Nome:</strong> {perfil.nome}</p>
          <p className="profile-detail-item"><strong>Email:</strong> {perfil.email}</p>
          <p className="profile-detail-item"><strong>Endereço:</strong> {perfil.endereco}</p>
          <p className="profile-detail-item"><strong>Telefone:</strong> {perfil.telefone}</p>
        </div>
      ) : (
        <p className="text-center">Carregando perfil...</p>
      )}
    </div>
  );
};

export default VisualizarPerfil;