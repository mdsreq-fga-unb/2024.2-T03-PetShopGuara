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