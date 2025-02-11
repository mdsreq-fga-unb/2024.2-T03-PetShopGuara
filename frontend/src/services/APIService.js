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
        const response = await axios.get(`https://two024-2-t03-petshopguara-esum.onrender.com/pets/consultar/${petId}`);
        return response.data;
    } catch (error) {
        console.error("Erro ao consultar pet:", error);
        throw error;
    }
}

export const consultarDadosPets = async (clienteId) => {
    const response = await fetch(`https://two024-2-t03-petshopguara-esum.onrender.com/pets/consultar/${clienteId}`);
    if (!response.ok) {
        throw new Error("Erro ao buscar pets");
    }
    return await response.json();
}

export const listarPets = async () => {
    const response = await fetch(`https://two024-2-t03-petshopguara-esum.onrender.com/pets/consultar`);
    if (!response.ok) {
        throw new Error("Erro ao buscar pets");
    }
    return await response.json();
}

export const cadastrarCliente = async (cliente) => {
    const response = await axios.post(`${API_URL}/cadastrar`, cliente);
    return response.data;
};

export async function realizarLogin(email, senha, perfil) {
    try {
        let uri = "https://two024-2-t03-petshopguara-esum.onrender.com/donos/login"
        switch (perfil) {
            case "Cliente":
                uri = "https://two024-2-t03-petshopguara-esum.onrender.com/donos/login"
                break;
            case "Dono":
                uri = "https://two024-2-t03-petshopguara-esum.onrender.com/api/dono/login"
                break;
            case "Funcionario":
                uri = "https://two024-2-t03-petshopguara-esum.onrender.com/api/funcionarios/login"
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

export const listarPerfil = async (clienteId) => {
    const response = await fetch(`https://two024-2-t03-petshopguara-esum.onrender.com/donos/consultar/${clienteId}`);
    if (!response.ok) {
        throw new Error("Perfil não logado!");
    }
    return await response.json();
}


export async function agendarServico(dadosAgendamento) {
    try {
        const idCliente = localStorage.getItem('@User_id');
        const response = await axios.post(`https://two024-2-t03-petshopguara-esum.onrender.com/agendamentos/agendar`, {
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

export async function visualizarAgendamento(){
    const response = await fetch("https://two024-2-t03-petshopguara-esum.onrender.com/agendamentos/calendario");
    if (!response.ok) {
        throw new Error("Erro ao agendamento!");
    }
    return await response.json();
}




