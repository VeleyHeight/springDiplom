import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom"
import Plus from '../SVG/Plus';
import Minus from '../SVG/Minus';

export const Basket = ({ basketData, setBasketData, loginData}) => {
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
  // const handleSubmitOrder = async () => {
  //   try {
  //     const orderData = {
  //       items: basketData.map((item) => ({
  //         productId: item.id,
  //         quantity: item.clickCount,
  //       })),
  //       clientCode: loginData['id'],
  //       paymentStatus: 'Ожидает подтверждения',
  //       deliveryCode: 1,
  //       deliveryAdress: 'Ярославль',
  //       deliveryStatus: 'Самовывоз'
  //     };
  //
  //     const response = await fetch('http://localhost:8080/orders', {
  //       method: 'POST',
  //       headers: {
  //         'Content-Type': 'application/json',
  //       },
  //       body: JSON.stringify(orderData),
  //     });
  //
  //     if (response.ok) {
  //       const data = await response.json();
  //       console.log('Заказ успешно создан:', data);
  //     } else {
  //       console.error('Ошибка при создании заказа:', response.status);
  //     }
  //   } catch (error) {
  //     console.error('Ошибка при создании заказа:', error);
  //   }
  // };

  return (
    <div className="flex flex-row py-8 bg-gray-300 min-h-screen">
      {basketData.length === 0 ? (
        <div className="max-h-56 w-[1000px] bg-white rounded-lg p-8 shadow-lg m-10 min-h-0">
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
                          className="text-gray-800 font-bold py-1 px-2"
                        >
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
          {basketData.length > 0 && (
            <div className="w-[500px] max-h-48 bg-white rounded-lg p-8 shadow-lg m-10 flex flex-col justify-between">
              <div className="flex justify-between items-center">
                <p className="text-3xl font-bold">Итого:</p>
                <p className="text-3xl font-bold">{getTotalPrice()} руб.</p>
              </div>
              {loginData ? (
  <Link to="/orders" >
    <button className="bg-yellow-500 w-full h-[50px] text-gray-800 font-bold py-2 px-8 rounded-full text-xl" >
      Перейти к оформлению заказа
    </button>
  </Link>
) : (
  <Link to="/login" >
    <button className="bg-yellow-500 w-full h-[50px] text-gray-800 font-bold py-2 px-8 rounded-full text-xl" >
      Перейти к оформлению заказа
    </button>
  </Link>
)}
            </div>
          )}
        </div>
      )}
    </div>
  );
};
// onClick={handleSubmitOrder}