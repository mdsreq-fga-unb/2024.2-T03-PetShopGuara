import React, { useState } from "react";
import { realizarLogin } from "../../services/APIService";
import "./Login.css"; // Importando o CSS
import { useNavigate } from "react-router-dom";

const Login = () => {
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [perfil, setPerfil] = useState("Cliente");

    const [error, setError] = useState(null);
    const navigate = useNavigate();
    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await realizarLogin(email, senha, perfil);

            // Exemplo: Redirecionar ou exibir dados do usuário
            navigate("/");
        } catch (err) {
            setError("Falha no login. Verifique suas credenciais.");
        }
    };

    return (
        <div className="login-container">
            {/* Imagem acima do título */}
            <div>
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
                <div className="login-input-container">
                    <label htmlFor="perfil" className="login-label">
                        Perfil:
                    </label>
                    <select
                        className="form-select form-control-lg"
                        value={perfil}
                        onChange={(e) => setPerfil(e.target.value)}
                    >
                        <option value="Dono">Dono</option>
                        <option value="Funcionario">Funcionário</option>
                        <option value="Cliente">Cliente</option>
                    </select>
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
