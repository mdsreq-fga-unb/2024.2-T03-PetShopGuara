import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

export async function getFunctions() {
    const response = await axios.get(`${API_URL}/`);
    return response.data;
}

export async function cadastrarPet(pet) {
    try {
        const response = await axios.post(`${API_URL}/pets/cadastrar`, pet);
        return response.data;
    } catch (error) {
        console.error("Erro ao cadastrar pet:", error);
        throw error;
    }
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

export async function realizarLogin(email, senha, perfil) {
    try {
        let uri = "http://localhost:8080/donos/login"
        switch (perfil) {
            case "Cliente":
                uri = "http://localhost:8080/donos/login"
                break;
            case "Dono":
                uri = "http://localhost:8080/api/dono/login"
                break;
            case "Funcionario":
                uri = "http://localhost:8080/api/funcionarios/login"
                break;
        }
        const response = await axios.get(`${uri}/${email}/${senha}`, {
            email,
            senha
        });
        localStorage.setItem('@User_id', JSON.stringify(response.data.id))
        localStorage.setItem('@User_name', JSON.stringify(response.data.nome))

        return response.data;
    } catch (error) {
        console.error("Erro ao realizar login:", error);
        throw error;
    }
}

export async function agendarServico(dadosAgendamento) {
    try {
        const idCliente = localStorage.getItem('@User_id');
        const response = await axios.post(`http://localhost:8080/agendamentos/agendar`, {
            pet: dadosAgendamento.petSelecionado,
            cliente: idCliente,
            dataHora: dadosAgendamento.dataHora,
            servico: dadosAgendamento.servico
        });
        return response.data;
    } catch (error) {
        console.error("Erro ao agendar serviço:", error);
        throw error;
    }
}

export const listarPets = async () => {
    const response = await fetch("http://localhost:8080/pets/consultar");
    if (!response.ok) {
        throw new Error("Erro ao buscar pets");
    }
    return await response.json();
}


