import React, { useState, useEffect } from "react";
import { consultarPet } from "../../services/APIService";

const PetDetails = ({ petId }) => {
    const [petData, setPetData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchPetData = async () => {
            try {
                const mockData = {
                    nome: "Fido",
                    especie: "Cachorro",
                    raca: "Golden Retriever",
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
        <div>
            <h2>Detalhes do Pet</h2>
            {petData && (
                <div>
                    <p>Nome: {petData.nome}</p>
                    <p>Espécie: {petData.especie}</p>
                    <p>Raça: {petData.raca}</p>
                </div>
            )}
        </div>
    );
};

export default PetDetails;
