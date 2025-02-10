import React from 'react';
import ReactDOM from 'react-dom/client';
import AppRoutes from './routes/Routes'; // Importando as rotas
import 'bootstrap/dist/css/bootstrap.min.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AppRoutes /> {/* Renderiza o sistema de rotas */}
  </React.StrictMode>
);


