import React from "react";
import { Outlet, useNavigate } from "react-router-dom";
import './App.css'; // Certifique-se de ter importado o arquivo CSS

const App = () => {
  const navigate = useNavigate(); // Hook para navegação

  const goBack = () => {
    navigate(-1); // Navega para a página anterior
  };

  return (
    <div className="d-flex vh-100">
      {/* Sidebar */}
      <nav className="sidebar text-white">
        <div className="p-3">
          <h3 className="titulo text-center fw-bold">PetShop Guará</h3>
          <img
            src="/logo.png"
            style={{ width: "200px", height: "auto" }}
            className="mt-3 rounded mx-auto d-block"
            alt="petguaraImage"
          />
          <ul className="nav flex-column mt-4">
            <li className="nav-item fw-bold">
              <a href="/" className="nav-link text-white">
                Home
              </a>
            </li>
            <li className="nav-item fw-bold">
              <a href="/pets" className="nav-link text-white">
                Meus Pets
              </a>
            </li>
            <li className="nav-item fw-bold">
              <a href="/agendar" className="nav-link text-white">
                Agendar
              </a>
            </li>
            <li className="nav-item fw-bold">
              <a href="/" className="nav-link text-white">
                Histórico
              </a>
            </li>
            <li className="nav-item fw-bold">
              <a href="/" className="nav-link text-white">
                Meu Perfil
              </a>
            </li>
          </ul>
        </div>
      </nav>

      {/* Conteúdo Principal */}
      <main className="content w-100">
        <div className="p-4">
          {/* Botão de Retroceder com ícone */}
          <button
            onClick={goBack}
            className="button btn-warning mb-4"
            style={{
              width: "50px",
              height: "50px",
              fontWeight: "bold",
              borderRadius: "50%", // Deixar o botão redondo
            }}
          >
            <i className="fas fa-arrow-left"></i> {/* Ícone de voltar */}
          </button>
          <Outlet /> {/* Renderiza o conteúdo da rota atual */}
        </div>
      </main>
    </div>
  );
};

export default App;

