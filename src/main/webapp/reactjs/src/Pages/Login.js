import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const Login = ({setLoginData}) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const handleSubmit = async (e) => {
    e.preventDefault();
  
    try {
      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });
  
      if (response.ok) {
        console.log('Данные успешно отправлены');
        // Перенаправить пользователя на страницу корзины
        const clientData = await response.json();

        setLoginData(clientData);

        console.log(clientData['id']);

      } else {
        const errorData = await response.json();
        setErrorMessage(errorData.error || 'Произошла ошибка при отправке данных');
        console.error('Ошибка при отправке данных:', JSON.stringify(errorData, null, 2));

      }
    } catch (error) {
      console.error('Ошибка при отправке данных:', error);
    }
  };

  return (
    <div className="flex bg-gray-300 justify-center items-center h-screen">
      <div className="bg-white rounded-lg shadow-md p-8 max-w-md w-full">
        <h1 className="text-2xl font-bold mb-6 text-center">Вход</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label htmlFor="username" className="block text-gray-700 font-bold mb-2">
              Логин <span className="text-red-500">*</span>
            </label>
            <input
              type="text"
              id="username"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              placeholder="Введите логин"
              required
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div className="mb-4">
            <label htmlFor="password" className="block text-gray-700 font-bold mb-2">
              Пароль <span className="text-red-500">*</span>
            </label>
            <input
              type="password"
              id="password"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              placeholder="Введите пароль"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          
          <p className="my-4 text-sm text-gray-500">
          <span className="text-red-500">*</span> — Обязательные поля
        </p>
          <div className="flex items-center justify-between">
            <button
              type="submit"
              className="bg-yellow-500 text-gray-700 font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            >
              Войти
            </button>
          </div>
        </form>

        <div className="mt-6 text-center">
          <p className="text-gray-700 text-lg">
            Нет аккаунта? Нажмите {' '}
            <Link to="/register" className="text-yellow-500 font-bold underline">
              сюда
            </Link>
            , чтобы зарегистрироваться
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;