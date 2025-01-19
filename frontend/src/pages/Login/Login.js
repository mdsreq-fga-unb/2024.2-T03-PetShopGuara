import React, { useState } from "react";
import { realizarLogin } from "../../services/APIService";

const Login = () => {
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [error, setError] = useState(null);

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await realizarLogin(email, senha);

            // Supondo que o backend retorna um token
            const { token, usuario } = response.data;

            // Salvar o token no localStorage ou onde preferir
            localStorage.setItem("token", token);

            // Exemplo: Redirecionar ou exibir dados do usuário
            alert(`Bem-vindo, ${usuario.nome}!`);
        } catch (err) {
            setError("Falha no login. Verifique suas credenciais.");
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="Digite seu email"
                        required
                    />
                </div>
                <div>
                    <label>Senha:</label>
                    <input
                        type="password"
                        value={senha}
                        onChange={(e) => setSenha(e.target.value)}
                        placeholder="Digite sua senha"
                        required
                    />
                </div>
                <button type="submit">Entrar</button>
            </form>
            {error && <p style={{ color: "red" }}>{error}</p>}
        </div>
    );
};

export default Login;
