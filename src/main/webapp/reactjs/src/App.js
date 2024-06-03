import Header from "./Components/Header";
import React, {useState} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css'
import RegistrationForm from './Pages/Register';
import { BasicTable } from './Pages/BasicTable';
import {BrowserRouter as Router,Routes, Route, Link}  from "react-router-dom"
import {Basket} from './Pages/Basket';
import Login from "./Pages/Login";
import { Orders } from "./Pages/Orders";
import {Lk} from "./Pages/Lk";

export default function App() {
  const [basketData, setBasketData] = useState([]);
  const [loginData, setLoginData] = useState(null);
  return (
    <Router>
      <Header loginData = {loginData}/>
        <Routes>
         <Route
          path="/"
          element={
            <BasicTable basketData={basketData}
              setBasketData={setBasketData}
            />
          }
        />
        <Route
          path="/basket"
          element={
            <Basket basketData={basketData}
             setBasketData={setBasketData}
             loginData={loginData}
             />
          }
        />
        <Route
          path="/orders"
          element={
            <Orders basketData={basketData}
             setBasketData={setBasketData}
             loginData={loginData}
             />
          }
        />
            <Route
                path="/lk"
                element={
                    <Lk
                            loginData={loginData}
                            setLoginData={setLoginData}
                    />
                }
            />
         <Route
          path="/login"
          element={
            <Login setLoginData={setLoginData} />
          }
          />
          <Route
          path="/register"
          element={
            <RegistrationForm
            />
          }
          />
      </Routes>
    </Router>
  );
}


