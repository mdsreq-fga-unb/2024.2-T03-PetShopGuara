import React, { useState } from "react";
import { realizarLogin } from "../../services/APIService";
import "./Login.css"; // Importando o CSS

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
        <div className="login-container">
            {/* Imagem acima do título */}
            <div>
                <h1 className="login-title">PetShop Guará</h1>
                <img
                    src="/logo.png"
                    alt="petguaraImage"
                    className="login-logo"
                />
            </div>

            {/* Subtítulo */}
            <h3 className="login-subtitle">Fazer Login</h3>

            <form onSubmit={handleLogin} className="login-form">
                {/* Campos de entrada */}
                <div className="login-input-container">
                    <label htmlFor="email" className="login-label">
                        Email:
                    </label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="Digite seu email"
                        required
                        className="login-input"
                    />
                </div>
                <div className="login-input-container">
                    <label htmlFor="senha" className="login-label">
                        Senha:
                    </label>
                    <input
                        type="password"
                        id="senha"
                        value={senha}
                        onChange={(e) => setSenha(e.target.value)}
                        placeholder="Digite sua senha"
                        required
                        className="login-input"
                    />
                </div>

                {/* Botão de login */}
                <button type="submit" className="login-button">
                    Entrar
                </button>
            </form>

            {/* Mensagem de erro */}
            {error && <p className="login-error">{error}</p>}
        </div>
    );
};

export default Login;
