import React, { useState, useEffect } from "react";
import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import { consultarAgendamentos } from "../../services/APIService";

const localizer = momentLocalizer(moment);

const VisualizarCalendario = () => {
    const [eventos, setEventos] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchAgendamentos = async () => {
            try {
                const agendamentos = await consultarAgendamentos();
                const eventosFormatados = agendamentos.map((agendamento) => ({
                    title: agendamento.nomeCliente + " - " + agendamento.servico,
                    start: new Date(agendamento.dataInicio),
                    end: new Date(agendamento.dataFim),
                }));
                setEventos(eventosFormatados);
            } catch (err) {
                setError("Erro ao carregar agendamentos.");
            }
        };
        fetchAgendamentos();
    }, []);

    return (
        <div>
            <h2>Calendário de Agendamentos</h2>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <Calendar
                localizer={localizer}
                events={eventos}
                startAccessor="start"
                endAccessor="end"
                style={{ height: 500, margin: "50px" }}
            />
        </div>
    );
};

export default VisualizarCalendario;
