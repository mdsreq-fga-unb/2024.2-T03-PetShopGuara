import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import { ConsultarPet } from "../../services/APIService";
import './ConsultarPet.css';

const PetDetails = ({ petId }) => {
    const [petData, setPetData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchPetData = async () => {
            try {
                const mockData = {
                    nome: "Fido",
                    especie: "Cachorro",
                    raca: "Golden Retriever",
                    cor: "Preto",
                    idade: "6 anos",
                    observacao: "Muito calmo e fácil de se lidar",
                    sexo: "Masculino",
                };
                setPetData(mockData); // Use dados mockados
            } catch (err) {
                setError("Erro ao carregar os dados do pet.");
            } finally {
                setLoading(false);
            }
        };

        fetchPetData();
    }, [petId]);  // Reexecuta sempre que o petId mudar

    if (loading) {
        return <div>Carregando...</div>;
    }

    if (error) {
        return <div>{error}</div>;
    }

    return (
      <div className="pet-details-container">
      <div className="d-flex justify-content-between align-items-center">
        <h1 className="text-primary fw-bold">Meus Pets 
          <button
          className="btn botao-adicionar btn-success ms-4" // Botão pequeno, verde, com ícone
          style={{ borderRadius: '5px' }}
          onClick={() => navigate('/cadastropets')} // Navega para a página de adicionar pet
        >
          <i className="fas fa-plus"></i> {/* Ícone de adição */}
        </button></h1>
        
        {/* Botão de Adicionar ao lado do título */}
      </div>
    
      {petData && (
        <div className="blue-box mt-3">
          <h2 className="pet-details-title">
            {petData ? `${petData.nome}` : "Detalhes do Pet"}
          </h2>
          <p className="pet-detail-item">Espécie: {petData.especie}</p>
          <p className="pet-detail-item">Raça: {petData.raca}</p>
          <p className="pet-detail-item">Cor: {petData.cor}</p>
          <p className="pet-detail-item">Idade: {petData.idade}</p>
          <p className="pet-detail-item">Observação: {petData.observacao}</p>
          <p className="pet-detail-item">Sexo: {petData.sexo}</p>
        </div>
      )}
    </div>
    );
  };

export default PetDetails;
