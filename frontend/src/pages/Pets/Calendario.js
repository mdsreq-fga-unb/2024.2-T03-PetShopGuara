import React, { useState, useEffect } from "react";
import { agendarServico, listarPets } from "../../services/APIService";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const Agendar = () => {
    const [pets, setPets] = useState([]);
    const [petSelecionado, setPetSelecionado] = useState(""); // Começa sem seleção
    const [data, setData] = useState("");
    const [hora, setHora] = useState("");
    const [servico, setServico] = useState("Banho");
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);

    useEffect(() => {
        const fetchPets = async () => {
            try {
                const response = await listarPets();
                setPets(response); // Apenas define a lista, sem seleção automática
            } catch (err) {
                console.error("Erro ao buscar pets:", err);
            }
        };
        fetchPets();
    }, []);


    const handleAgendamento = async (e) => {
        e.preventDefault();

        if (!petSelecionado) {
            setError("Por favor, selecione um pet.");
            return;
        }

        try {
            await agendarServico({ nomePet: petSelecionado, data, hora, servico });
            setSuccess({nomePet: petSelecionado, data, hora, servico });
            setError(null);
        } catch (err) {
            setError("Erro ao realizar o agendamento. Tente novamente.");
            setSuccess(null);
        }
    };

    return (
        <div>
            <h2>Agendar Serviço</h2>
            <form onSubmit={handleAgendamento}>
                <div>
                    <label> Selecione um pet:</label>
                    <select
                        value={petSelecionado}
                        onChange={(e) => setPetSelecionado(e.target.value)}
                        required
                    >
                        <option value="" disabled>Selecione um pet</option>
                        {pets.map((pet) => (
                            <option key={pet.id} value={pet.nome}>{pet.nome}</option>
                        ))}
                    </select>
                </div>
                <div>
                    <label>Data:</label>
                    <input
                        type="date"
                        value={data}
                        onChange={(e) => setData(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Hora:</label>
                    <input
                        type="time"
                        value={hora} onChange={(e) => setHora(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Serviço:</label>
                    <select value={servico} >
                        <option value="Banho">Banho</option>
                        <option value="Tosa">Tosa</option>
                        <option value="Consulta">Consulta</option>
                    </select>
                </div>
                <button type="submit">Agendar</button>
            </form>
            {success && <p style={{ color: "green" }}>{success}</p>}
            {error && <p style={{ color: "red" }}>{error}</p>}
        </div>
    );
};

export default Agendar;