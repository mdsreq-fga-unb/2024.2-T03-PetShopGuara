import React from "react";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./CadastrarPet.css";

const CadastroPet = () => {
  const [formData, setFormData] = useState({
    nome: "",
    especie: "",
    raca: "",
    cor: "",
    idade: "",
    observacao: "",
    // email: "",
    sexo: ""
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("https://two024-2-t03-petshopguara-esum.onrender.com/pets/cadastrar", formData);
      alert("Pet cadastrado com sucesso!");
      setFormData({
        nome: "",
        especie: "",
        raca: "",
        // email: "",
        cor: "",
        idade: "",
        observacao: "",
        sexo: ""
      });
      navigate("/pets");
    } catch (error) {
      alert("Erro ao cadastrar o pet.");
    }
  };

  return (
    <div className="container mt-4">
      <h2 className=" mb-4 fw-bold" style={{color: "#3D83CC", fontWeight: "bold"}}>Cadastro de Pet</h2>
      <form onSubmit={handleSubmit} className="custom-form fw-bold mt-4">
      <div className="form-group row g-3">
  <div className="col-md-6">
    <label className="form-label">Nome</label>
    <input type="text" className="form-control" name="nome" value={formData.nome} onChange={handleChange} required />
  </div>

  <div className="col-md-6">
    <label className="form-label">Espécie</label>
    <input type="text" className="form-control" name="especie" value={formData.especie} onChange={handleChange} required />
  </div>

  <div className="col-md-6">
    <label className="form-label">Raça</label>
    <input type="text" className="form-control" name="raca" value={formData.raca} onChange={handleChange} required />
  </div>

  {/*<div className="col-md-6">*/}
  {/*  <label className="form-label">Email</label>*/}
  {/*  <input type="text" className="form-control" name="email" value={formData.email} onChange={handleChange} required />*/}
  {/*</div>*/}

  <div className="col-md-6">
    <label className="form-label">Cor</label>
    <input type="text" className="form-control" name="cor" value={formData.cor} onChange={handleChange} required />
  </div>

  <div className="col-md-6">
    <label className="form-label">Idade</label>
    <input type="number" className="form-control" name="idade" value={formData.idade} onChange={handleChange} required />
  </div>

  <div className="col-md-6">
    <label className="form-label">Observação</label>
    <textarea className="form-control" name="observacao" value={formData.observacao} onChange={handleChange}></textarea>
  </div>

  <div className="col-md-6">
    <label className="form-label">Sexo</label>
    <select className="form-control" name="sexo" value={formData.sexo} onChange={handleChange} required>
      <option value="">Selecione</option>
      <option value="Macho">Macho</option>
      <option value="Fêmea">Fêmea</option>
    </select>
  </div>
</div>
        <button type="submit" className="mt-4 btn-cadastrar w-100" 
        >Cadastrar</button>
      </form>
    </div>
  );
};

export default CadastroPet;
