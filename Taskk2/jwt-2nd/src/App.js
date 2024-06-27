import './App.css';
import React, { useState } from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Login2 from './Login2';
import Home from './Home';




const App = () => {
  const [token, setToken] = useState(localStorage.getItem('token'));

  const handleLogin = (token) => {
      localStorage.setItem('token', token);
      setToken(token);
  };

  const handleLogout = () => {
      localStorage.removeItem('token');
      setToken(null);
  };

  return (
    <div className='App mt-3'>
      <Routes>
          <Route
              path="/login2"
              element={!token ? <Login2 onLogin={handleLogin} /> : <Navigate to="/" />}
          />
          <Route
              path="/"
              element={token ? <Home onLogout={handleLogout} /> : <Navigate to="/login2" />}
          />
      </Routes>
      </div>
  );
};

export default App;