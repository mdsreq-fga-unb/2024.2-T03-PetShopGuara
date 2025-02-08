import React, { useState, useEffect } from "react";
import { agendarServico, listarPets } from "../../services/APIService";
import { useNavigate } from "react-router-dom";
import "./Calendario.css";
import "bootstrap/dist/css/bootstrap.min.css";

const Agendar = () => {
    const [pets, setPets] = useState([]);
    const [petSelecionado, setPetSelecionado] = useState("");
    const [data, setData] = useState("");
    const [hora, setHora] = useState("");
    const [servico, setServico] = useState("Banho");
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);

    useEffect(() => {
        const fetchPets = async () => {
            try {
                const response = await listarPets();
                setPets(response);
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
            setSuccess({ nomePet: petSelecionado, data, hora, servico });
            setError(null);
        } catch (err) {
            setError("Erro ao realizar o agendamento. Tente novamente.");
            setSuccess(null);
        }
    };

    return (
        <div className="container">
            <h2 className="text-center text-primary mb-"style={{color: "#3D83CC", fontWeight: "bold"}} >Agendar Serviço</h2>
            <form className="custom-form p-4 shadow" onSubmit={handleAgendamento}>
                <div className="mb-3">
                    <label className="form-label fw-bold">Selecione um pet:</label>
                    <select
                        className="form-select form-control-lg"
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
                <div className="mb-3">
                    <label className="form-label fw-bold">Data:</label>
                    <input
                        type="date"
                        className="form-control form-control-lg"
                        value={data}
                        onChange={(e) => setData(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label fw-bold">Hora:</label>
                    <input
                        type="time"
                        className="form-control form-control-lg"
                        value={hora}
                        onChange={(e) => setHora(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label fw-bold">Serviço:</label>
                    <select
                        className="form-select form-control-lg"
                        value={servico}
                        onChange={(e) => setServico(e.target.value)}
                    >
                        <option value="Banho">Banho</option>
                        <option value="Tosa">Tosa</option>
                        <option value="Consulta">Consulta</option>
                    </select>
                </div>
                <button type="submit" className="btn-agendar tn-lg w-100">Agendar</button>
            </form>
            {success && <div className="alert alert-success mt-3 text-center">Agendamento realizado com sucesso!</div>}
            {error && <div className="alert alert-danger mt-3 text-center">{error}</div>}
        </div>
    );
};

export default Agendar;