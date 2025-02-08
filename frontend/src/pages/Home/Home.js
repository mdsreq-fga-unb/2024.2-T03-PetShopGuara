import React from "react";
import { useNavigate } from "react-router-dom"; // Importa o hook para redirecionamento
import "./Home.css"; // Importa o arquivo CSS para estilos adicionais

const HomePage = () => {
  const navigate = useNavigate(); // Inicializa o hook de navegação

  const handleRedirect = () => {
    navigate("/agendar"); // Substitua "/pagina-destino" pela rota desejada
  };
  const handleRedirect2 = () => {
    navigate("/cadastro"); // Substitua "/pagina-destino" pela rota desejada
  };
  const handleRedirect3 = () => {
    navigate("/login"); // Substitua "/pagina-destino" pela rota desejada
  };


  return (
    <div className="d-flex justify-content-center">
      <div className="blue-box d-flex flex-column">
        <img
          src="/Vector.png"
          style={{ width: "300px", height: "auto" }}
          className="mt-3 rounded mx-auto d-block"
          alt="imageinicial"
        />
        <button
          className="botao-agendar mt-4" // Usando classes do Bootstrap para estilizar o botão
          onClick={handleRedirect}
        >
          Agendar Agora
        </button>
        <button
          className="botao-cadastro mt-4" // Usando classes do Bootstrap para estilizar o botão
          onClick={handleRedirect2}
        >
         Cadastre-se
        </button>
        <button
          className="botao-login mt-4" // Usando classes do Bootstrap para estilizar o botão
          onClick={handleRedirect3}
        >
          Fazer Login
        </button>
      </div>
    </div>
  );
};

export default HomePage;
