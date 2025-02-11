import React, { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const Agendamentos = () => {
    const [agendamentos, setAgendamentos] = useState([]);
    useEffect(() => {
       const fetchAgendamentos = async () => {
            try {
                const response = await fetch("https://two024-2-t03-petshopguara-esum.onrender.com/agendamentos/consultar");
                if (!response.ok) {
                    throw new Error("Erro ao buscar agendamentos");
                }
                const data = await response.json();
                setAgendamentos(data);
            } catch (error) {
                console.error("Erro ao carregar agendamentos:", error);
            }
        };
        fetchAgendamentos();
    }, []);

    return (
        <div className="container mt-4">
            <h2 className="text-center text-primary mb-4" style={{ color: "#3D83CC", fontWeight: "bold" }}>Agendamentos</h2>
            <div className="table-responsive">
                <table className="table table-striped table-hover">
                    <thead className="table-primary">
                        <tr>
                            <th>Cliente</th>
                            <th>Data</th>
                            <th>Hora</th>
                            <th>Serviço</th>
                        </tr>
                    </thead>
                    <tbody>
                        {agendamentos.length > 0 ? (
                            agendamentos.map((agendamento) => (
                                <tr key={agendamento.id}>
                                    <td>{agendamento.cliente}</td>
                                    <td>{new Date(agendamento.dataHora).toLocaleDateString()}</td>
                                    <td>{new Date(agendamento.dataHora).toLocaleTimeString([], { hour: "2-digit", minute: "2-digit" })}</td>
                                    <td>{agendamento.servico}</td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="4" className="text-center">Nenhum agendamento encontrado.</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Agendamentos;
