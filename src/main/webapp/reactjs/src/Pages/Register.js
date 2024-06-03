import React, { useState } from 'react';

export default function RegistrationForm() {
  const [isCompany, setIsCompany] = useState(true);
  const [mainCompany, setMainCompany] = useState('');

  const handleRadioChange = (e) => {
    setIsCompany(e.target.value === 'company');
    if (e.target.value === 'company') {
      setMainCompany(document.getElementById('companyName').value);
    } else {
      setMainCompany('');
    }
  };

  return (
    <div className="min-h-screen bg-gray-300 flex items-center justify-center p-4">
      <div className="bg-white shadow-md rounded-lg px-8 pt-6 pb-8 mb-4 max-w-md w-full">
        <h1 className="block text-gray-700 text-center text-2xl font-bold mb-6">
          Регистрация
        </h1>
        <div className="my-4 flex items-center justify-center text-xl">
          <h2 className="block text-gray-700 text-center font-bold mb-6">
            Тип покупателя
          </h2>
          <div className="ml-4">
            <div className="mb-2">
              <label>
                <input
                  type="radio"
                  value="company"
                  checked={isCompany}
                  onChange={handleRadioChange}
                  className="mr-2"
                />
                ИП
              </label>
            </div>
            <div>
              <label>
                <input
                  type="radio"
                  value="individual"
                  checked={!isCompany}
                  onChange={handleRadioChange}
                  className="mr-2"
                />
                Юридическое лицо
              </label>
            </div>
          </div>
        </div>
        <h2 className="block text-gray-700 text-lg font-bold mb-2">Данные для входа</h2>
        <form onSubmit={(event) => sendFormData(event, isCompany, mainCompany)}>
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="login">
              Логин <span className="text-red-600">*</span>
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              id="login"
              type="text"
              placeholder="Введите логин"
              required
            />
          </div>
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="password">
              Пароль <span className="text-red-600">*</span>
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
              id="password"
              type="password"
              placeholder="Введите пароль"
              required
            />
          </div>
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="passwordConfirm">
              Подтверждение пароля <span className="text-red-600">*</span>
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
              id="passwordConfirm"
              type="password"
              placeholder="Повторите пароль"
              required
            />
          </div>
          <div className="mb-4">
            <h2 className="block text-gray-700 text-lg font-bold mb-2">Информация о компании</h2>
            {isCompany ? (
              <>
                 <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="companyName">
                    Название компании <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="companyName"
                    type="text"
                    placeholder="Название компании"
                    required
                  />
                  </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="address">
                    Адрес <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="address"
                    type="text"
                    placeholder="Адрес"
                    required
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="region">
                    Регион
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="region"
                    type="text"
                    placeholder="Регион"
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="inn">
                    ИНН <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="inn"
                    type="text"
                    placeholder="ИНН"
                    required
                  />
                </div>
                
              </>
            ) : (
              <>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="companyName">
                    Название компании <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="companyName"
                    type="text"
                    placeholder="Название компании"
                    required
                  />
                  <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="mainCompany">
              Основная организация <span className="text-red-600">*</span>
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              id="mainCompany"
              type="text"
              placeholder="Основная организация"
              value={mainCompany}
              onChange={(e) => setMainCompany(e.target.value)}
              required
            />
          </div>
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="address">
                    Адрес <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="address"
                    type="text"
                    placeholder="Адрес"
                    required
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="region">
                    Регион
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="region"
                    type="text"
                    placeholder="Регион"
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="inn">
                    ИНН <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="inn"
                    type="text"
                    placeholder="ИНН"
                    required
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="kpp">
                    КПП <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="kpp"
                    type="text"
                    placeholder="КПП"
                    required
                  />
                </div>
                
              </>
            )}
          </div>
          <div className="mb-4">
          <h2 className="block text-gray-700 text-lg font-bold mb-2">Контактные данные</h2>
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="lastName">
                    Фамилия <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="lastName"
                    type="text"
                    placeholder="Фамилия"
                    required
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="firstName">
                    Имя <span className="text-red-600">*</span>
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="firstName"
                    type="text"
                    placeholder="Имя"
                    required
                  />
                </div>
                <div className="mb-4">
                  <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="patronymic">
                    Отчество 
                  </label>
                  <input
                    className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    id="patronymic"
                    type="text"
                    placeholder="Отчество"
                  />
                </div>
                <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="email">
                Email <span className="text-red-600">*</span>
              </label>
              <input
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="email"
                type="email"
                placeholder="Email"
                required
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="phone">
                Телефон <span className="text-red-600">*</span>
              </label>
              <input
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="phone"
                type="tel"
                placeholder="Телефон"
                required
              />
            </div>
          <div className="bg-yellow-500 text-gray-700 font-bold py-2 px-4 rounded-full flex justify-center mt-8"
              type="submit">
          <button className="justify-center" type="submit">Зарегистрироваться</button>
          </div>
        </form>
      </div>
    </div>
  );
}
function sendFormData(event,isCompany, mainCompany) {
  event.preventDefault();

  const formData = {
    login: document.getElementById('login').value,
    password: document.getElementById('password').value,
    passwordConfirm: document.getElementById('passwordConfirm').value,
    companyName: document.getElementById('companyName').value,
    address: document.getElementById('address').value,
    region: document.getElementById('region').value,
    inn: document.getElementById('inn').value,
    kpp: isCompany ? '' : document.getElementById('kpp').value,
    lastName: document.getElementById('lastName').value,
    firstName: document.getElementById('firstName').value,
    patronymic: document.getElementById('patronymic').value,
    email: document.getElementById('email').value,
    phone: document.getElementById('phone').value,
    isCompany: isCompany,
    mainCompany: mainCompany
  };

  fetch('http://localhost:8080/register', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(formData)
  })
  .then(response => {
    if (response.ok) {
      console.log('Данные успешно отправлены');
    } else {
      console.error('Ошибка при отправке данных');
    }
  })
  .catch(error => {
    console.error('Ошибка при отправке данных:', error);
  });
}