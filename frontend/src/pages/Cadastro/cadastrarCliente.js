import React, {useState} from "react";
import axios from 'axios';
import {cadastrarCliente} from "../../services/APIService"; // Importa a função Axios
import './cadastrarCliente.css'
import { useNavigate } from "react-router-dom";

const CadastrarDono = () => {

    const [nome, setNome] = React.useState("");
    const [email, setEmail] = React.useState("");
    const [endereco, setEndereco] = React.useState("");
    const [telefone, setTelefone] = React.useState("");
    const [senha, setSenha] = React.useState("");
    const navigate = useNavigate();

    // Função para lidar com mudanças nos campos do formulário
    const onChangeEmail = (event) => {
        setEmail(event.target.value);
    };
    const onChangeNome = (event) => {
        setNome(event.target.value);
    };
    const onChangeEndereco = (event) => {
        setEndereco(event.target.value);
    };
    const onChangeTelefone = (event) => {
        setTelefone(event.target.value);
    };
    const onChangeSenha = (event) => {
        setSenha(event.target.value);
    };


    // Função para submeter o formulário
    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/donos/cadastrar', {
                email: email, nome: nome, endereco: endereco, telefone: telefone, senha: senha
            });
            alert("Dono cadastrado com sucesso!");
            navigate("/login");
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
                style={{width: "500px", height: "auto"}}
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

                <h2 className="text-center mb-4 fw-bold" style={{color: "#ffffff", fontWeight: "bold"}}>
                    Fazer Cadastro</h2>
                <form onSubmit={handleSubmit} className="custom-form p-4">
                    <div className="form-group row mb-3">
                        <label htmlFor="nome" className="col-sm-3 col-form-label text-end fw-bold">
                            <i className="fas fa-user"></i> Nome:
                        </label>
                        <div className="col-sm-9">
                            <input onChange={onChangeNome}
                                type="text"
                                id="nome"
                                className="form-control"
                                placeholder="Digite seu nome"
                            />
                        </div>
                    </div>

                    <div className="form-group row mb-3">
                        <label htmlFor="email" className="col-sm-3 col-form-label text-end fw-bold">
                            <i className="fas fa-envelope"></i> E-mail:
                        </label>
                        <div className="col-sm-9">
                            <input onChange={onChangeEmail}
                                type="email"
                                id="email"
                                className="form-control"
                                placeholder="Digite seu e-mail"
                            />
                        </div>
                    </div>

                    <div className="form-group row mb-3">
                        <label htmlFor="telefone" className="col-sm-3 col-form-label text-end fw-bold">
                            <i className="fas fa-phone"></i> Telefone:
                        </label>
                        <div className="col-sm-9">
                            <input onChange={onChangeTelefone}
                                type="text"
                                id="telefone"
                                className="form-control"
                                placeholder="Digite seu telefone"
                            />
                        </div>
                    </div>

                    <div className="form-group row mb-3">
                        <label htmlFor="endereco" className="col-sm-3 col-form-label text-end fw-bold">
                            <i className="fas fa-home"></i> Endereço:
                        </label>
                        <div className="col-sm-9">
                            <input onChange={onChangeEndereco}
                                type="text"
                                id="endereco"
                                className="form-control"
                                placeholder="Digite seu endereço"
                            />
                        </div>
                    </div>

                    <div className="form-group row mb-3">
                        <label htmlFor="senha" className="col-sm-3 col-form-label text-end fw-bold">
                            <i className="fas fa-lock"></i> Senha:
                        </label>
                        <div className="col-sm-9">
                            <input onChange={onChangeSenha}
                                type="password"
                                id="senha"
                                className="form-control"
                                placeholder="Digite sua senha"
                            />
                        </div>
                    </div>

                    <div className="form-group row mb-3">
                        <label htmlFor="confirmarSenha" className="col-sm-3 col-form-label text-end fw-bold">
                            <i className="fas fa-lock"></i> Confirmar:
                        </label>
                        <div className="col-sm-9">
                            <input
                                type="password"
                                id="confirmarSenha"
                                className="form-control"
                                placeholder="Confirme sua senha"
                            />
                        </div>
                    </div>
                    <button
                        type="submit"
                        className="btn-cadastro w-100"
                        style={{
                            backgroundColor: "#FF7F00",
                            height: "60px", fontWeight: "bold", fontSize: "18px"
                        }}
                    >
                        Cadastre-se
                    </button>
                </form>

            </div>
        </div>
    );
};


export default CadastrarDono;

  
