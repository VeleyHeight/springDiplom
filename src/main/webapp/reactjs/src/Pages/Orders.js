import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom"
import Plus from '../SVG/Plus';
import Minus from '../SVG/Minus';

export const Orders = ({ basketData, setBasketData, loginData}) => {
  const handleQuantityChange = (index, value) => {
    if (value === 0) {
      setBasketData((prevData) =>
        prevData.filter((_, i) => i !== index)
      );
    } else {
      setBasketData((prevData) => {
        const updatedData = [...prevData];
        updatedData[index].clickCount = value;
        return updatedData;
      });
    }
  };

  const decrementQuantity = (index) => {
    const item = basketData[index];
    if (item.clickCount > 0) {
      handleQuantityChange(index, item.clickCount - 1);
    }
  };

  const incrementQuantity = (index) => {
    const item = basketData[index];
    handleQuantityChange(index, item.clickCount + 1);
  };

  const getTotalPrice = () => {
    return basketData.reduce((total, item) => total + item.price * item.clickCount, 0).toFixed(2);
  };

  const getProductNoun = (count) => {
    const lastDigit = count % 10;
    const lastTwoDigits = count % 100;

    if (lastDigit === 1 && lastTwoDigits !== 11) {
      return 'товар';
    } else if ([2, 3, 4].includes(lastDigit) && ![12, 13, 14].includes(lastTwoDigits)) {
      return 'товара';
    } else {
      return 'товаров';
    }
  };
  const handleSubmitOrder = async () => {
    try {
      const fromTime = document.getElementById('from_time').value;
      const toTime = document.getElementById('to_time').value;
      const orderData = {
        items: basketData.map((item) => ({
          productId: item.id,
          quantity: item.clickCount,
        })),
        clientCode: loginData['id'], 
        paymentStatus: 'При получении', 
        deliveryAdress: selectedDeliveryMethod === 'pickup' ? document.getElementById('deliveryCity').value : document.getElementById('deliveryCity1').value,
        deliveryStatus: selectedDeliveryMethod === 'pickup' ? 'Самовывоз' : 'Доставка транспортной компанией',
        deliveryTimeFrom: fromTime,
        deliveryTimeTo: toTime,
      };
  
      const response = await fetch('http://localhost:8080/orders', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(orderData),
      });
  
      if (response.ok) {
        const data = await response.json();
        console.log('Заказ успешно создан:', data);
      } else {
        console.error('Ошибка при создании заказа:', response.status);
      }
    } catch (error) {
      console.error('Ошибка при создании заказа:', error);
    }
  };

  const [selectedDeliveryMethod, setSelectedDeliveryMethod] = useState('pickup');

  const handleDeliveryMethodChange = (method) => {
    setSelectedDeliveryMethod(method);
  };

  return (
    <div className="flex flex-row py-8 bg-gray-300 min-h-screen">
      
      {basketData.length === 0 ? (
        <div className="max-h-56 w-[1000px] bg-white rounded-lg p-8 shadow-lg m-10">
          <h1 className="text-2xl font-bold mb-4 my-5">Корзина пуста</h1>
          <div className="text-xl my-10 ">
            <Link to="/" className="underline text-yellow-500">
              Нажмите здесь
            </Link>
            , чтобы продолжить покупки
          </div>
        </div>
      ) : (
        <div className="w-full flex">
          <div className="w-full flex flex-col">
          <div class="flex-grow bg-white rounded-lg p-8 shadow-lg m-10 overflow-auto">
      <h2 className='text-2xl font-bold mb-4'>Ваши данные</h2>
            <div class="space-y-4">
              <div class="flex justify-between items-center">
                <label for="client_id" class="font-bold">Номер клиента</label>
                <input type="text" id="client_id" name="client_id" value={loginData['id']} readonly
                       class=" rounded px-4 py-2"/>
              </div>
              <div class="flex justify-between items-center">
                <label for="firm" class="font-bold">Наименование организации</label>
                <input type="text" id="firm" name="firm" value={loginData['company']} readonly
                       class=" rounded px-4 py-2"/>
              </div>
              {loginData['companyForm'] !== 'Физлицо' && (
                  <div class="flex justify-between items-center">
                    <label for="main_organization" class="font-bold">Основная организация</label>
                    <input type="text" id="main_organization" name="main_organization" value={loginData['companyMain']}
                           readonly class=" rounded px-4 py-2"/>
                  </div>
              )}
              <div class="flex justify-between items-center">
                <label for="inn" class="font-bold">ИНН</label>
                <input type="text" id="inn" name="inn" value={loginData['inn']} readonly class=" rounded px-4 py-2"/>
              </div>
              {loginData['companyForm'] !== 'Физлицо' && (
                  <div class="flex justify-between items-center">
                    <label for="kpp" class="font-bold">КПП</label>
                    <input type="text" id="kpp" name="kpp" value={loginData['kpp']} readonly
                           class=" rounded px-4 py-2"/>
                  </div>
              )}
              <div class="flex justify-between items-center">
                <label for="adress" class="font-bold">Адрес</label>
                <input type="text" id="adress" name="adress" value={loginData['adres']} readonly
                       class="rounded px-4 py-2"/>
              </div>
              {loginData['region'] !== '' && (
                  <div class="flex justify-between items-center">
                    <label for="region" class="font-bold">Регион</label>
                    <input type="text" id="region" name="region" value={loginData['region']} readonly
                           class="rounded px-4 py-2"/>
                  </div>
              )}
              {loginData['companyForm'] !== 'Физлицо' && (
                  <div class="flex justify-between items-center">
                    <label for="companyFormUR" class="font-bold">Юр. / Физ. лицо</label>
                    <input type="text" id="companyFormUR" name="companyFormUR" value={loginData['companyForm']} readonly
                           class=" rounded px-4 py-2"/>
                  </div>
              )}
              {loginData['companyForm'] !== 'Юрлицо' && (
                  <div class="flex justify-between items-center">
                    <label for="companyFormIP" class="font-bold">Юр. / Физ. лицо</label>
                    <input type="text" id="companyFormIP" name="companyFormIP" value={loginData['companyForm']} readonly
                           class="rounded px-4 py-2"/>
                  </div>
              )}
              <div class="flex justify-between items-center">
                <label for="client_surname" class="font-bold">Фамилия</label>
                <input type="text" id="client_surname" name="client_surname" value={loginData['surname']}
                       class="rounded px-4 py-2 readonly"/>
              </div>
              <div class="flex justify-between items-center">
                <label for="client_name" class="font-bold">Имя</label>
                <input type="text" id="client_name" name="client_name" value={loginData['name']}
                       class="rounded px-4 py-2 readonly"/>
              </div>
              {loginData['othce'] != null && (
                  <div class="flex justify-between items-center">
                    <label for="client_patronymic" class="font-bold">Отчество</label>
                    <input type="text" id="client_patronymic" name="client_patronymic" value={loginData['othce']}
                           class=" rounded px-4 py-2 readonly"/>
                  </div>
              )}
              <div class="flex justify-between items-center">
                <label for="phone_number" class="font-bold">Номер телефона</label>
                <input type="text" id="phone_number" name="phone_number" value={loginData['phone']}
                       class=" rounded px-4 py-2 readonly"/>
              </div>
              <div class="flex justify-between items-center">
                <label for="email" class="font-bold">E-mail</label>
                <input type="email" id="email" name="email" value={loginData['email']}
                       class=" rounded px-4 py-2 readonly"/>
              </div>
              <Link to="/lk" className="underline text-yellow-500">
              <button className="bg-yellow-500 w-full h-[50px] text-gray-800 font-bold py-2 px-8 rounded-full text-xl"
                      >
                Изменить данные
              </button>
              </Link>
            </div>
          </div>
            <div className="flex-grow bg-white rounded-lg p-8 shadow-lg m-10 overflow-auto">
              <h2 className="text-2xl font-bold mb-4">Данные доставки</h2>
              <legend className='font-bold'>Вид доставки</legend>
      <div className="flex space-x-4">
        <div className="flex items-center">
          <input
            id="pickup"
            name="del_type"
            type="radio"
            value="pickup"
            checked={selectedDeliveryMethod === 'pickup'}
            onChange={() => handleDeliveryMethodChange('pickup')}
            className="mr-2"
          />
          <label htmlFor="pickup" className='text-gray-500'>Самовывоз</label>
        </div>
        <div className="flex items-center">
          <input
            id="delivery_by_company"
            name="del_type"
            type="radio"
            value="delivery_by_company"
            checked={selectedDeliveryMethod === 'delivery_by_company'}
            onChange={() => handleDeliveryMethodChange('delivery_by_company')}
            className="mr-2"
          />
          <label htmlFor="delivery_by_company" className='text-gray-500'>Доставка транспортной компанией</label>
        </div>
      </div>
      <legend className='font-bold'>Способ оплаты</legend>
      <div className="flex items-center">
        <input id="payment_on_receipt" name="payment_method" type="radio" value="payment_on_receipt" required defaultChecked className="mr-2" />
        <label htmlFor="payment_on_receipt" className='text-gray-500'>При получении</label>
      </div>
      {selectedDeliveryMethod === 'pickup' ? (
        <div className="flex justify-between items-center">
          <label htmlFor="deliveryCity" className="font-bold">Самовывоз со склада в городе:</label>
          <input type="text" id="deliveryCity" name="deliveryCity" required className="bg-gray-300 rounded px-4 py-2" />
        </div>
      ) : (
        <div className="flex justify-between items-center">
          <label htmlFor="deliveryCity" className="font-bold">Предположительный адрес доставки для торговой компании:</label>
          <input type="text" id="deliveryCity1" name="deliveryCity1" required className="bg-gray-300 rounded px-4 py-2" />
        </div>
      )}
  <legend>Удобное время получения товара</legend>
  <div className="flex justify-between items-center">
    <div className="flex items-center">
      <label htmlFor="from_time" className=" mr-2">Не раньше</label>
      <input type="time" id="from_time" name="from_time" required className="bg-gray-300 rounded px-4 py-2" />
    </div>
    <div className="flex items-center">
      <label htmlFor="to_time" className=" mr-2">Не позднее</label>
      <input type="time" id="to_time" name="to_time" required className="bg-gray-300 rounded px-4 py-2" />
    </div>
  </div>
</div>
          <div className="flex-grow bg-white rounded-lg p-8 shadow-lg m-10 overflow-auto">
            <h1 className="text-2xl font-bold mb-4">{basketData.length} {getProductNoun(basketData.length)} в корзине</h1>
            <table className="table-auto w-full border-collapse">
              <tbody>
                {basketData.map((item, index) => (
                  <tr key={index} className="border-b">
                    <td className="px-4 py-2">
                      <span className="block font-bold">{item.name}</span>
                      <span className="block text-gray-500">Артикуль: {item.id}</span>
                    </td>
                    <td className="px-4 py-2 flex items-center justify-center">
                      <div className="items-center mt-2 max-w-32 bg-gray-300 rounded-full flex justify-center">
                        <button
                          onClick={() => decrementQuantity(index)}
                          className="text-gray-800 font-bold py-1 px-2">
                          <Minus/>
                        </button>
                        <input
                          type="number"
                          value={item.clickCount}
                          min="0"
                          onChange={(e) => { if (e.target.value >= 1) { handleQuantityChange(index, parseInt(e.target.value)) } else { handleQuantityChange(index, 1) } }}
                          className="w-10 px-2 py-1 border-none bg-gray-300 text-gray-800 text-center text-lg"
                        />
                        <button
                          onClick={() => incrementQuantity(index)}
                          className="text-gray-800 font-bold py-1 px-2"
                        >
                          <Plus/>
                        </button>
                      </div>
                    </td>
                    <td className="px-4 py-2 text-black font-bold text-xl">{(item.price * item.clickCount).toFixed(2)} руб.</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          </div>
          {basketData.length > 0 && (
            <div className="w-[500px] max-h-48 bg-white rounded-lg p-8 shadow-lg m-10 flex flex-col justify-between">
              <div className="flex justify-between items-center">
                <p className="text-3xl font-bold">Итого:</p>
                <p className="text-3xl font-bold">{getTotalPrice()} руб.</p>
              </div>
              <button className="bg-yellow-500 w-full h-[50px] text-gray-800 font-bold py-2 px-8 rounded-full text-xl" onClick={handleSubmitOrder}>
                Оформить заказ
              </button>
            </div>
          )}
        </div>
      )}
    </div>
  );
};