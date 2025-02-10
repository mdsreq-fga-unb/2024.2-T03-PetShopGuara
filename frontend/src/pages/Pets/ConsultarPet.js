import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import {consultarDadosPets, listarPets} from "../../services/APIService";
import "./ConsultarPet.css";

const PetDetails = () => {
    const [pets, setPets] = useState([]);
    const [clienteId ] = useState(localStorage.getItem('@User_id'));
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchPets = async () => {
            try {
                const response = await listarPets(); //consultarDadosPets(clienteId)
                setPets(response);
            } catch (err) {
                console.error("Erro ao buscar pets:", err);
                setError("Erro ao carregar os pets.");
            } finally {
                setLoading(false);
            }
        };
        fetchPets();
    }, []);

    if (loading) {
        return <div>Carregando...</div>;
    }

    if (error) {
        return <div>{error}</div>;
    }

    return (
        <div className="pet-details-container">
            <div className="d-flex justify-content-between align-items-center">
                <h1 className="text-primary fw-bold">
                    Meus Pets
                    <button
                        className="btn botao-adicionar btn-success ms-4"
                        style={{ borderRadius: "5px" }}
                        onClick={() => navigate("/cadastropets")}
                    >
                        <i className="fas fa-plus"></i>
                    </button>
                </h1>
            </div>
            <div className="pets-list" style={{display: "flex", flexWrap: "wrap", gap: "20px"}}>
                {pets.length > 0 ? (
                    pets.map((pet) => (
                        <div key={pet.id} className="pet-item blue-box mt-3">
                            <h2 className="pet-details-title">{pet.nome || "Detalhes do Pet"}</h2>
                            <p className="pet-detail-item">Espécie: {pet.especie}</p>
                            <p className="pet-detail-item">Raça: {pet.raca}</p>
                            <p className="pet-detail-item">Cor: {pet.cor}</p>
                            <p className="pet-detail-item">Idade: {pet.idade}</p>
                            <p className="pet-detail-item">Observação: {pet.observacao}</p>
                            <p className="pet-detail-item">Sexo: {pet.sexo}</p>
                        </div>
                    ))
                ) : (
                    <p>Nenhum pet cadastrado.</p>
                )}
            </div>
        </div>
    );
};

export default PetDetails;
