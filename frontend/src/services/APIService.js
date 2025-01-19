import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

export async function getFunctions() {
    const response = await axios.get(`${API_URL}/`);
    return response.data;
}

export async function consultarPet(petId) {
    try {
        const response = await axios.get(`${API_URL}/pets/consultar/${petId}`);
        return response.data;
    } catch (error) {
        console.error("Erro ao consultar pet:", error);
        throw error;
    }
}

export const cadastrarCliente = async (cliente) => {
    const response = await axios.post(`${API_URL}/cadastrar`, cliente);
    return response.data;
  };

export async function realizarLogin(email, senha) {
    try {
        const response = await axios.post(`${API_URL}/login`, {
            email: email,
            senha: senha,
        });
        return response.data;
    } catch (error) {
        console.error("Erro ao realizar login:", error);
        throw error;
    }
}

export async function agendarServico(dadosAgendamento) {
    try {
        const response = await axios.post(`${API_URL}/agendamentos`, dadosAgendamento);
        return response.data;
    } catch (error) {
        console.error("Erro ao agendar serviço:", error);
        throw error;
    }
}


