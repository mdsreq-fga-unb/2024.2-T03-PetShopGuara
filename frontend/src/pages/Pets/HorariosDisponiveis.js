import React, { useState, useEffect } from "react";
import { consultarHorariosDisponiveis } from "../../services/APIService";

const HorariosDisponiveis = () => {
    const [horarios, setHorarios] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchHorarios = async () => {
            try {
                const response = await consultarHorariosDisponiveis();
                setHorarios(response);
            } catch (err) {
                setError("Erro ao carregar horários disponíveis.");
            }
        };
        fetchHorarios();
    }, []);

    return (
        <div>
            <h2>Horários Disponíveis</h2>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <ul>
                {horarios.map((horario, index) => (
                    <li key={index}>{horario}</li>
                ))}
            </ul>
        </div>
    );
};

export default HorariosDisponiveis;
