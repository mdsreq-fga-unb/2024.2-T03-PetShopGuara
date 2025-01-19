import React, { useState } from "react";
import axios from 'axios';
import { cadastrarCliente } from "../../services/APIService"; // Importa a função Axios

const CadastrarDono = () => {
    // Estado para armazenar os dados do formulário
    const [formData, setFormData] = useState({
      nome: '',
      telefone: '',
      endereco: '',
    });
  
    // Função para lidar com mudanças nos campos do formulário
    const handleChange = (event) => {
      const { name, value } = event.target;
      setFormData({
        ...formData,
        [name]: value,
      });
    };
  
    // Função para submeter o formulário
  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('/donos/cadastrar', formData);
      alert("Dono cadastrado com sucesso!");
    } catch (error) {
      alert("Erro ao cadastrar dono. Tente novamente.");
    }
  };

  
  //SEÇÃO PARA HTML
  return ( 
<div
  className="d-flex justify-content-center align-items-center"
  style={{
    minHeight: "100vh",
  }} 
>
<img
      src="/logo.png"
      style={{ width: "500px", height: "auto" }}
      className="mt-3 rounded mx-auto d-block"
      alt="petguaraImage"
    />
    
  <div
    className="container-fluid p-4"
    style={{
      backgroundColor: "#3D83CC", // Azul do retângulo
      borderRadius: "10px",
      maxWidth: "600px",
      width: "80%",
      boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)",
    }}
  >
    
    <h2 className="text-center mb-4 fw-bold"style={{ color: "#ffffff", fontWeight: "bold" }}>
      Fazer Cadastro</h2>
      <form className="custom-form">
      <div className="form-group mb-3 fw-bold">
        <label htmlFor="nome">
          <i className="fas fa-user"></i> Nome
        </label>
        <input
          type="text"
          id="nome"
          className="form-control "
          placeholder="Digite seu nome"
        />
      </div>
      <div className="form-group mb-3 fw-bold">
        <label htmlFor="email">
          <i className="fas fa-envelope"></i> E-mail
        </label>
        <input
          type="email"
          id="email"
          className="form-control"
          placeholder="Digite seu e-mail"
        />
      </div>
      <div className="form-group mb-3 fw-bold">
        <label htmlFor="telefone">
          <i className="fas fa-phone"></i> Telefone
        </label>
        <input
          type="text"
          id="telefone"
          className="form-control"
          placeholder="Digite seu telefone"
        />
      </div>
      <div className="form-group mb-3 fw-bold">
        <label htmlFor="endereco">
          <i className="fas fa-home"></i> Endereço
        </label>
        <input
          type="text"
          id="endereco"
          className="form-control"
          placeholder="Digite seu endereço"
        />
      </div>
      <div className="form-group mb-3 fw-bold">
        <label htmlFor="senha">
          <i className="fas fa-lock"></i> Senha
        </label>
        <input
          type="password"
          id="senha"
          className="form-control"
          placeholder="Digite sua senha"
        />
      </div>
      <div className="form-group mb-3 fw-bold">
        <label htmlFor="confirmarSenha">
          <i className="fas fa-lock"></i> Confirmar Senha
        </label>
        <input
          type="password"
          id="confirmarSenha"
          className="form-control"
          placeholder="Confirme sua senha"
        />
      </div>
    </form>
    <button
        type="submit"
        className="btn btn-block w-100"
        style={{ backgroundColor: "#FF7F00",
          height: "60px",  fontWeight: "bold", fontSize: "18px" }}
      >
        Cadastre-se
      </button>
  </div>
</div>
  );
};
  


  export default CadastrarDono;

  
