import React, { useState, useEffect } from "react";
import { agendarServico, listarPets } from "../../services/APIService";
import { useNavigate } from "react-router-dom";
import "./Calendario.css";
import "bootstrap/dist/css/bootstrap.min.css";

const Agendar = () => {
    const [pets, setPets] = useState([]);
    const [petSelecionado, setPetSelecionado] = useState(0); // Começa sem seleção
    const [data, setData] = useState("");
    const [hora, setHora] = useState("");
    const [servico, setServico] = useState("Banho");

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
            alert("Por favor, selecione um pet.");
            return;
        }
        try {

            const dataHora = new Date(`${data} ${hora}`);
            await agendarServico({petSelecionado, dataHora, servico});
            alert(`Agendamento realizado com sucesso!`);
        } catch (err) {
            alert(`Erro ao realizar agendamento!`);
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
                        <option value={0} disabled>Selecione um pet</option>
                        {pets.map((pet) => (
                            <option key={pet.id} value={pet.id}>{pet.nome}</option>
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
        </div>
    );
};

export default Agendar;