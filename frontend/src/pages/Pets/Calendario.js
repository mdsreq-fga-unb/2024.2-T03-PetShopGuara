import React, { useState } from "react";
import { agendarServico } from "../../services/APIService";

const Agendar = () => {
    const [nomePet, setNomePet] = useState("");
    const [data, setData] = useState("");
    const [hora, setHora] = useState("");
    const [servico, setServico] = useState("Banho");
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);

    const handleAgendamento = async (e) => {
        e.preventDefault();

        try {
            const response = await agendarServico({ nomePet, data, hora, servico });

            // Sucesso
            setSuccess(`Agendamento realizado para ${nomePet} às ${hora} no dia ${data}.`);
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
                    <label>Nome do Pet:</label>
                    <input
                        type="text"
                        value={nomePet}
                        onChange={(e) => setNomePet(e.target.value)}
                        placeholder="Digite o nome do pet"
                        required
                    />
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
                        value={hora}
                        onChange={(e) => setHora(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Serviço:</label>
                    <select value={servico} onChange={(e) => setServico(e.target.value)}>
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
